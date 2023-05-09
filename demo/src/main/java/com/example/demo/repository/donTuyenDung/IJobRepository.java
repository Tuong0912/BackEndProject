package com.example.demo.repository.donTuyenDung;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepository extends JpaRepository<Job, Long> {
    @Query(value = "select j from Job as j where j.salary between :minSalary and :maxSalary ")
    Iterable<Job> findAllBySalaryBetween(@Param("minSalary") double minSalary, @Param("maxSalary") double maxSalary);

    @Query(value = "select j from Job as j where " +
            "(j.qualification.name like %:qualification% or j.qualification.name = '') " +
            "and (j.city.name like %:city% or j.city.name='') " +
            "and (j.salary between :minSalary and :maxSalary) ")
    Iterable<Job> findAllByQualificationAndCityAndSalary(@Param("qualification") String qualification,
                                                         @Param("city") String city,
                                                         @Param("minSalary") double minSalary,
                                                         @Param("maxSalary") double maxSalary);

}
