package com.example.demo.service.interservice;

import com.example.demo.model.*;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IJobService extends IGeneralService<Job> {
    Iterable<Job> findAllByMinSalaryAndMaxSalary(double minSalary, double maxSalary);

    Iterable<Job> findAllByQualificationAndCityAndSalaryBetweenMinSalaryAndMaxSalary(String qualification,
                                                                                     String city,
                                                                                     double minSalary,
                                                                                     double maxSalary);

    Page<Job> findAllJobWhichTrue(Pageable pageable);

    Page<Job> findAllJobWhichFalse(Pageable pageable);


    int browseJob(long id);

    Iterable<Job> findTopByRecruitments();

    Iterable<Job> selectRandomFromJob();
}
