package com.example.demo.service.iplm;

import com.example.demo.model.Qualification;
import com.example.demo.repository.donTuyenDung.IQualificationRepo;
import com.example.demo.service.interservice.IQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QualificationService implements IQualificationService {
    @Autowired
    private IQualificationRepo iQualificationRepo;
    @Override
    public Iterable<Qualification> findAll() {
        return this.iQualificationRepo.findAll();
    }

    @Override
    public Optional<Qualification> findById(Long id) {
        return this.iQualificationRepo.findById(id);
    }

    @Override
    public Qualification add(Qualification qualification) {
     return    this.iQualificationRepo.save(qualification);
    }

    @Override
    public void delete(Long id) {
        this.iQualificationRepo.deleteById(id);
    }
}
