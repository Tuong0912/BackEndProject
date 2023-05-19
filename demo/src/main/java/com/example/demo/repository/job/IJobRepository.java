package com.example.demo.repository.job;

import com.example.demo.model.job.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@Transactional
public interface IJobRepository extends JpaRepository<Job, Long> {
    @Query(value = "select j from Job as j where j.salary between :minSalary and :maxSalary ")
    Iterable<Job> findAllBySalaryBetween(@Param("minSalary") double minSalary, @Param("maxSalary") double maxSalary);

    @Query(value = "select j from Job as j where " +
            "(j.qualification.name like %:qualification% or j.qualification.name = '') " +
            "and (j.city.name like %:city% or j.city.name='') " +
            "and (j.salary between :minSalary and :maxSalary) and j.status = true")
    Iterable<Job> findAllByQualificationAndCityAndSalary(@Param("qualification") String qualification,
                                                         @Param("city") String city,
                                                         @Param("minSalary") double minSalary,
                                                         @Param("maxSalary") double maxSalary);

    @Query(value = "select j from Job as j where j.status is false ")
    Page<Job> findAllByStatusIsFalse(Pageable pageable);

    @Modifying
    @Query(value = "update Job as j set j.status = true  where j.id = :id")
    int browseAJob(@PathVariable long id);

    @Modifying
    @Query(value = "select * from job where status = true order by job.salary DESC limit 3", nativeQuery = true)
    Iterable<Job> findTopByRecruitments();

    @Modifying
    @Query(value = "select * from job where status = true order by rand() limit 1", nativeQuery = true)
    Iterable<Job> selectRandomFromJob();

    @Query(value = "select j from Job as j where j.status is true")
    Page<Job> findAllByStatusIsTrue(Pageable pageable);


}
