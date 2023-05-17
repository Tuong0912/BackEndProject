package com.example.demo.controller;

import com.example.demo.model.user.Role;
import com.example.demo.service.interservice.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    @GetMapping()
    ResponseEntity<Iterable<Role>> findAll() {
        return new ResponseEntity<>(iRoleService.findAll(), HttpStatus.OK);
    }
}
