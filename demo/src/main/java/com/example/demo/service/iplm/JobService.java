package com.example.demo.service.iplm;

import com.example.demo.model.*;
import com.example.demo.repository.donTuyenDung.IJobRepository;
import com.example.demo.service.interservice.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService implements IJobService {

    @Autowired
    private IJobRepository iJobRepository;

    @Override
    public Iterable<Job> findAll() {
        return iJobRepository.findAll();
    }

    @Override
    public Optional<Job> findById(Long id) {
        return iJobRepository.findById(id);
    }

    @Override
    public Job add(Job job) {
        return iJobRepository.save(job);
    }

    @Override
    public void delete(Long id) {
        iJobRepository.deleteById(id);
    }

    @Override
    public Iterable<Job> findAllByCityAndEnterpriseAndProgramingLanguageAndQualification(City city, Enterprise enterprise, ProgramingLanguage programingLanguage, Qualification qualification) {
        return iJobRepository.findAllByCityAndEnterpriseAndProgramingLanguageAndQualification(city, enterprise, programingLanguage, qualification);
    }

    @Override
    public Iterable<Job> findAllByCity(City city) {
        return iJobRepository.findAllByCity(city);
    }

    @Override
    public Iterable<Job> findAllByEnterprise(Enterprise enterprise) {
        return iJobRepository.findAllByEnterprise(enterprise);
    }

    @Override
    public Iterable<Job> findAllByProgramingLanguage(ProgramingLanguage language) {
        return iJobRepository.findAllByProgramingLanguage(language);
    }

    @Override
    public Iterable<Job> findAllByQualification(Qualification qualification) {
        return iJobRepository.findAllByQualification(qualification);
    }
}
