package com.example.demo.service.interservice;

import com.example.demo.model.*;
import com.example.demo.service.IGeneralService;

public interface IJobService extends IGeneralService<Job> {
    Iterable<Job> findAllByMinSalaryAndMaxSalary(double minSalary, double maxSalary);

    Iterable<Job> findAllByCity(String city);

    public Iterable<Job> findAllByQualificationAndCityAndSalaryBetweenMinSalaryAndMaxSalary(String qualification, String city, double minSalary, double maxSalary);
}
