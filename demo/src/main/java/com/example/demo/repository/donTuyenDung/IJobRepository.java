package com.example.demo.repository.donTuyenDung;

import com.example.demo.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
@Transactional
public interface IJobRepository extends JpaRepository<Job, Long> {
    @Query(value = "select j from Job as j where j.salary between :minSalary and :maxSalary ")
    Iterable<Job> findAllBySalaryBetween(@Param("minSalary") double minSalary, @Param("maxSalary") double maxSalary);

    @Query(value = "select j from Job as j where " +
            "(j.qualification.name like %:qualification% or j.qualification.name = '') " +
            "and (j.city.name like %:city% or j.city.name='') " +
            "and (j.salary between :minSalary and :maxSalary) ")
    Page<Job> findAllByQualificationAndCityAndSalary(@Param("qualification") String qualification,
                                                     @Param("city") String city,
                                                     @Param("minSalary") double minSalary,
                                                     @Param("maxSalary") double maxSalary,
                                                     Pageable pageable);

    @Query(value = "select j from Job as j where j.status is true")
    Page<Job> findAllByStatusIsTrue(Pageable pageable);
   @Query(value = "select j from Job as j where j.status is false ")
    Page<Job> findAllByStatusIsFalse(Pageable pageable);

   @Modifying
   @Query(value = "update Job as j set j.status = true  where j.id = :id")
    int browseAJob (@PathVariable long id);
}
