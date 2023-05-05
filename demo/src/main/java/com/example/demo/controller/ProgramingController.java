package com.example.demo.controller;

import com.example.demo.model.ProgramingLanguage;
import com.example.demo.service.interservice.IProgramingLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("language")
public class ProgramingController {
    @Autowired
    private IProgramingLanguageService iProgramingService;

    @GetMapping
    public ResponseEntity<Iterable<ProgramingLanguage>> findAll() {
        return new ResponseEntity<>(this.iProgramingService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgramingLanguage> createNewJob(@RequestBody ProgramingLanguage language) {
        this.iProgramingService.add(language);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Optional<ProgramingLanguage>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iProgramingService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProgramingLanguage> updateJob(@PathVariable Long id, @RequestBody ProgramingLanguage language) {
        if (this.iProgramingService.findById(id).isPresent()) {
            this.iProgramingService.add(language);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iProgramingService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
