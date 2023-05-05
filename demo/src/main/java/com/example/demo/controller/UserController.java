package com.example.demo.controller;

import com.example.demo.model.user.User;
import com.example.demo.service.interservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll() {
        return new ResponseEntity<>(this.iUserService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createNewJob(@RequestBody User user) {
        this.iUserService.add(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iUserService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> updateJob(@PathVariable Long id, @RequestBody User user) {
        if (this.iUserService.findById(id).isPresent()) {
            this.iUserService.add(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iUserService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("check/{id}")
    public ResponseEntity<User> checkApplication(@PathVariable Long id) {
        User user = this.iUserService.checkApplication(id);
        if (user.isaBoolean()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }else {
            user.setaBoolean(true);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
