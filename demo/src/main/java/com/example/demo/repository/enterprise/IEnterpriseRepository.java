package com.example.demo.repository.enterprise;

import com.example.demo.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
