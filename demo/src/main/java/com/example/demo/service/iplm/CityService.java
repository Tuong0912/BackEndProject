package com.example.demo.service.iplm;

import com.example.demo.model.City;
import com.example.demo.repository.city.ICityRepository;
import com.example.demo.service.interservice.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CityService implements ICityService {
   @Autowired
   private ICityRepository iCityRepository;

    @Override
    public Iterable<City> findAll() {
        return iCityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return iCityRepository.findById(id);
    }

    @Override
    public void add(City city) {
        iCityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        iCityRepository.deleteById(id);
    }
}
