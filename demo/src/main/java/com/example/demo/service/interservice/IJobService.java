package com.example.demo.service.interservice;

import com.example.demo.model.*;
import com.example.demo.service.IGeneralService;

public interface IJobService extends IGeneralService<Job> {
    Iterable<Job> findAllByCityAndEnterpriseAndProgramingLanguageAndQualification(City city, Enterprise enterprise, ProgramingLanguage programingLanguage, Qualification qualification);

    Iterable<Job> findAllByCity(City city);

    Iterable<Job> findAllByEnterprise(Enterprise enterprise);

    Iterable<Job> findAllByProgramingLanguage(ProgramingLanguage language);

    Iterable<Job> findAllByQualification(Qualification qualification);
}
