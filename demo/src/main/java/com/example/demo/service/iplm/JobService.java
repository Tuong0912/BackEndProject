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
    public Iterable<Job> findAllByMinSalaryAndMaxSalary(double minSalary, double maxSalary) {
        return iJobRepository.findAllBySalaryBetween(minSalary, maxSalary);
    }

    @Override
    public Iterable<Job> findAllByCity(String city) {
        return iJobRepository.findAllByCity(city);
    }

    @Override
    public Iterable<Job> findAllByQualification(String qualification) {
        return iJobRepository.findAllByQualification(qualification);
    }
}
