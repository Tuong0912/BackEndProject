package com.example.demo.repository.job;

import com.example.demo.model.job.ApplyJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyJobRepository extends JpaRepository<ApplyJob, Long> {
}
