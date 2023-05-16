package com.example.demo.service.iplm;

import com.example.demo.model.job.ProgramingLanguage;
import com.example.demo.repository.job.IProgramingLanguageRepo;
import com.example.demo.service.interservice.IProgramingLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgramingLanguageService implements IProgramingLanguageService {
    @Autowired
    private IProgramingLanguageRepo iProgramingLanguageRepo;

    @Override
    public Iterable<ProgramingLanguage> findAll() {
        return iProgramingLanguageRepo.findAll();
    }

    @Override
    public Optional<ProgramingLanguage> findById(Long id) {
        return iProgramingLanguageRepo.findById(id);
    }

    @Override
    public ProgramingLanguage add(ProgramingLanguage programingLanguage) {
        return iProgramingLanguageRepo.save(programingLanguage);
    }

    @Override
    public void delete(Long id) {
        iProgramingLanguageRepo.deleteById(id);
    }
}
