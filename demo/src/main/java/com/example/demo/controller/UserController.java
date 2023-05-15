package com.example.demo.controller;

import com.example.demo.model.user.User;
import com.example.demo.service.interservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;



    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        List<User> users = (List<User>) userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserInformation(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(userOptional.get().getId());
        return new ResponseEntity<>(userService.add(user), HttpStatus.OK);
    }

    @PatchMapping("check/{id}")
    public ResponseEntity<User> checkApplication(@PathVariable Long id) {
        User user = this.userService.checkApplication(id);
        if (user.isaBoolean()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            user.setaBoolean(true);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("User name already exists");
        } else {
            userService.add(user);
            return ResponseEntity.ok().body("User register successfully");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response) {
        if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())) {
            Cookie cookie = new Cookie("user", user.getUsername());
            cookie.setMaxAge(30*60);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return ResponseEntity.ok("Login success");
        }else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
    }
}
