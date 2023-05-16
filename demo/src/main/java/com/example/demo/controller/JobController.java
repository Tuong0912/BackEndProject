package com.example.demo.controller;

import com.example.demo.model.job.Job;
import com.example.demo.model.Search;
import com.example.demo.service.interservice.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
        job.setStatus(false);
        this.iJobService.add(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Optional<Job>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iJobService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job) {
        if (iJobService.findById(id).isPresent()) {
            iJobService.add(job);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        iJobService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/search")
    ResponseEntity<Iterable<Job>> search(@RequestBody Search search) {
        return new ResponseEntity<>(iJobService.findAllByMinSalaryAndMaxSalary(search.getMinSalary(),
                search.getMaxSalary()),
                HttpStatus.OK);
    }

    @PostMapping("/qualification")
    ResponseEntity<Iterable<Job>> searchByQualification(@RequestBody Search search) {
        return new ResponseEntity<>(iJobService.findAllByQualificationAndCityAndSalaryBetweenMinSalaryAndMaxSalary(search.getQualification(),
                search.getCity(),
                search.getMinSalary(),
                search.getMaxSalary()),
                HttpStatus.OK);
    }

    @GetMapping("findAllTrue")
    ResponseEntity<Page<Job>> findAllJobWhichTrue(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(iJobService.findAllJobWhichTrue(pageable), HttpStatus.OK);
    }

    @GetMapping("findAllFalse")
    ResponseEntity<Page<Job>> findAllJobWhichFalse(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(iJobService.findAllJobWhichFalse(pageable), HttpStatus.OK);
    }

    @PostMapping("/browse/{id}")
    ResponseEntity<Optional<Job>> browseAJob(@PathVariable long id) {
        iJobService.browseJob(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("showTop")
    ResponseEntity<Iterable<Job>> showTopRecruitments() {
        return new ResponseEntity<>(iJobService.findTopByRecruitments(), HttpStatus.OK);
    }

    @PostMapping("selectRandom")
    ResponseEntity<Iterable<Job>> selectRandomFromJob() {
        return new ResponseEntity<>(iJobService.selectRandomFromJob(), HttpStatus.OK);
    }

}
