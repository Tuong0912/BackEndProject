package com.example.demo.repository.donTuyenDung;

import com.example.demo.model.ProgramingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgramingLanguageRepo extends JpaRepository<ProgramingLanguage, Long> {
}
