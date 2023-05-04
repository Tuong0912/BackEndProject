package com.example.demo.service.iplm;

import com.example.demo.model.Qualification;
import com.example.demo.service.interservice.IQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QualificationService implements IQualificationService {
    @Autowired
    @Override
    public Iterable<Qualification> findAll() {
        return null;
    }

    @Override
    public Optional<Qualification> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void add(Qualification qualification) {

    }

    @Override
    public void delete(Long id) {

    }
}
