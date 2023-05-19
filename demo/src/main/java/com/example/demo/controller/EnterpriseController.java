package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Enterprise;
import com.example.demo.service.interservice.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("enterprise")
public class EnterpriseController {
    @Autowired
    private IEnterpriseService iEnterpriseService;

    @GetMapping()
    ResponseEntity<Page<Enterprise>> findAll(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(iEnterpriseService.findAllEnterPrise(pageable), HttpStatus.OK);
    }

    @PostMapping("create")
    ResponseEntity<Enterprise> addNewEnterprise(@RequestBody Enterprise enterprise) {
        this.iEnterpriseService.add(enterprise);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    ResponseEntity<Enterprise> updateEnterprise(@PathVariable Long id, @RequestBody Enterprise enterprise) {
        if (this.iEnterpriseService.findById(id).isPresent()) {
            this.iEnterpriseService.add(enterprise);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    ResponseEntity<Optional<Enterprise>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iEnterpriseService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iEnterpriseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
