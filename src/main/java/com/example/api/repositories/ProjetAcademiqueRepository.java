package com.example.api.repositories;

import com.example.api.models.ProjetAcademique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetAcademiqueRepository extends JpaRepository<ProjetAcademique, Long> {
    List<ProjetAcademique> findByEnseignantId(int enseignantId);
}
