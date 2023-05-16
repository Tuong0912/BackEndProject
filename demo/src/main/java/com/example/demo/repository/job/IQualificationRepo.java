package com.example.demo.repository.job;

import com.example.demo.model.job.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQualificationRepo extends JpaRepository<Qualification, Long> {
}
