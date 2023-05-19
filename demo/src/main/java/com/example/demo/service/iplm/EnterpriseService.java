package com.example.demo.service.iplm;

import com.example.demo.model.Enterprise;
import com.example.demo.repository.enterprise.IEnterpriseRepository;
import com.example.demo.service.interservice.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnterpriseService implements IEnterpriseService {
    @Autowired
    private IEnterpriseRepository iEnterpriseRepository;

    @Override
    public Iterable<Enterprise> findAll() {
        return iEnterpriseRepository.findAll();
    }

    @Override
    public Optional<Enterprise> findById(Long id) {
        return iEnterpriseRepository.findById(id);
    }

    @Override
    public Enterprise add(Enterprise enterprise) {
        return iEnterpriseRepository.save(enterprise);
    }

    @Override
    public void delete(Long id) {
        iEnterpriseRepository.deleteById(id);
    }

    @Override
    public Page<Enterprise> findAllEnterPrise(Pageable pageable) {
        return iEnterpriseRepository.findAllEnterPrise(pageable);
    }
}
