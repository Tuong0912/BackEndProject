package com.example.demo.service.iplm;

import com.example.demo.model.Job;
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
    public void add(Job job) {
        iJobRepository.save(job);
    }

    @Override
    public void delete(Long id) {
        iJobRepository.deleteById(id);
    }
}