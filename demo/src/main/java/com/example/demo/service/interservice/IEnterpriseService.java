package com.example.demo.service.interservice;

import com.example.demo.model.Enterprise;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEnterpriseService extends IGeneralService<Enterprise> {
    Page<Enterprise> findAllEnterPrise(Pageable pageable);


}
