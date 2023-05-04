package com.example.demo.service.iplm;

import com.example.demo.model.ProgramingLanguage;
import com.example.demo.repository.donTuyenDung.IProgramingLanguageRepo;
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
    public void add(ProgramingLanguage programingLanguage) {
        iProgramingLanguageRepo.save(programingLanguage);
    }

    @Override
    public void delete(Long id) {
        iProgramingLanguageRepo.deleteById(id);
    }
}
