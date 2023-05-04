package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.interservice.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("city")
public class CityController {
    @Autowired
    private ICityService iCityService;

    @GetMapping()
    ResponseEntity<Iterable<City>> findAll() {
        return new ResponseEntity<>(iCityService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Void> createNewCity(@RequestBody City city) {
        this.iCityService.add(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Optional<City>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iCityService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iCityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    ResponseEntity<Void> updateCity(@PathVariable Long id, @RequestBody City city) {
        if (this.iCityService.findById(id).isPresent()) {
            this.iCityService.add(city);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
