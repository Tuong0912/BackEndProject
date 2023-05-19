package com.example.demo.repository.enterprise;

import com.example.demo.model.Enterprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnterpriseRepository extends JpaRepository<Enterprise, Long> {
    @Query(value = "select e from Enterprise as e ")
    Page<Enterprise> findAllEnterPrise(Pageable pageable);
}
