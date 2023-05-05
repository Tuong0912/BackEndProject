package com.example.demo.controller;

import com.example.demo.model.Job;
import com.example.demo.service.interservice.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("job")
public class JobController {
    @Autowired
    private IJobService iJobService;

    @GetMapping
    public ResponseEntity<Iterable<Job>> findAll() {
        return new ResponseEntity<>(this.iJobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> createNewJob(@RequestBody Job job) {
        job.setPostDate(java.time.LocalDate.now());
        this.iJobService.add(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Optional<Job>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iJobService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job) {
        if (this.iJobService.findById(id).isPresent()) {
            this.iJobService.add(job);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iJobService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
