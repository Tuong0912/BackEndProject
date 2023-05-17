package com.example.demo.controller;

import com.example.demo.model.login.LoginRequest;
import com.example.demo.model.user.User;
import com.example.demo.service.interservice.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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
        if (userService.findByUserEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already exists");
        } else {
            userService.add(user);
            return ResponseEntity.ok().body("User register successfully");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User userLogin) {
        Map<String, Object> hasMap = new HashMap<>();
        String text;
        User user = userService.findByUserEmail(userLogin.getEmail());
        if (user == null) {
            text = "Email không tồn tại";
            hasMap.put("text", text);
            return new ResponseEntity<>(hasMap, HttpStatus.OK);
        } else {
            if (user.getPassword().equals(userLogin.getPassword())) {
                text = "Đăng nhập thành công";
                hasMap.put("text", text);
                hasMap.put("user1234567890", user);
                return new ResponseEntity<>(hasMap, HttpStatus.OK);
            } else {
                text = "Mật khẩu không đúng";
                hasMap.put("text", text);
                return new ResponseEntity<>(hasMap, HttpStatus.OK);
            }
        }


    }

    @GetMapping("findAllFalse")
    public ResponseEntity<Page<User>> findAllWhichFalse(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(userService.findAllUserWhichFalse(pageable), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id).get(), HttpStatus.OK);
    }
}
