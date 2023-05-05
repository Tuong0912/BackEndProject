package com.example.demo.controller;


import com.example.demo.model.Qualification;
import com.example.demo.service.interservice.IQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("qualification")
public class QualificationController {
    @Autowired
    private IQualificationService iQualificationService;

    @GetMapping
    public ResponseEntity<Iterable<Qualification>> findAll() {
        return new ResponseEntity<>(this.iQualificationService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Qualification> createNewJob(@RequestBody Qualification qualification) {
        this.iQualificationService.add(qualification);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Optional<Qualification>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iQualificationService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Qualification> updateJob(@PathVariable Long id, @RequestBody Qualification qualification) {
        if (this.iQualificationService.findById(id).isPresent()) {
            this.iQualificationService.add(qualification);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iQualificationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
