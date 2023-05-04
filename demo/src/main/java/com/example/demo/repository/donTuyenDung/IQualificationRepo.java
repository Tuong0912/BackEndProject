package com.example.demo.repository.donTuyenDung;

import com.example.demo.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQualificationRepo extends JpaRepository<Qualification, Long> {
}
