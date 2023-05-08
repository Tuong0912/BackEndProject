package com.example.demo.repository.donTuyenDung;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepository extends JpaRepository<Job, Long> {
    Iterable<Job> findAllByCityAndEnterpriseAndProgramingLanguageAndQualification(City city, Enterprise enterprise, ProgramingLanguage programingLanguage, Qualification qualification);

    Iterable<Job> findAllByCity(City city);

    Iterable<Job> findAllByEnterprise(Enterprise enterprise);

    Iterable<Job> findAllByProgramingLanguage(ProgramingLanguage language);

    Iterable<Job> findAllByQualification(Qualification qualification);
}
