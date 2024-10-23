package com.example.api.repositories;

import com.example.api.models.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer> {
    // Requête pour récupérer uniquement les noms des matières par l'ID de l'enseignant
    @Query("SELECT m.nom FROM Matiere m WHERE m.enseignant.id = :enseignantId")
    List<String> findMatiereNamesByEnseignant_Id(int enseignantId);

    // Requête pour récupérer les noms et contenus des cours d'une matière par l'ID de la matière
    @Query("SELECT c.nom, c.contenu FROM Cours c WHERE c.matiere.id = :matiereId")
    List<Object[]> findCoursNamesAndContentsByMatiereId(int matiereId);
}
