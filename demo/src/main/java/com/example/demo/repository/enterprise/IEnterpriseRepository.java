package com.example.demo.repository.enterprise;

import com.example.demo.model.Enterprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@Transactional
public interface IEnterpriseRepository extends JpaRepository<Enterprise, Long> {
    @Query(value = "select e from Enterprise as e ")
    Page<Enterprise> findAllEnterPrise(Pageable pageable);

    @Modifying
    @Query(value = "update Enterprise as e set e.status = true where e.id = :id")
    int browseAEnterprise(@PathVariable long id);
}
