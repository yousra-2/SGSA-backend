package com.example.api.controllers;

import com.example.api.models.Cours;
import com.example.api.models.Etudiant;
import com.example.api.services.MatiereService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MatiereController {

    private final MatiereService matiereService;

    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    // Récupérer les noms et contenus des cours d'une matière
    @GetMapping("/matieres/{matiereId}/cours")
    public ResponseEntity<List<Object[]>> getCoursByMatiereId(@PathVariable int matiereId) {
        List<Object[]> cours = matiereService.findCoursNamesAndContentsByMatiereId(matiereId);
        if (cours.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }

        List<Object[]> result = new ArrayList<>();
        for (Object[] item : cours) {
            result.add(item); // Ajoutez le nom et le contenu du cours
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/matieres/{matiereId}/cours")
    public ResponseEntity<Cours> addCours(@PathVariable int matiereId, @RequestBody Cours cours) {
        Cours savedCours = matiereService.addCoursToMatiere(matiereId, cours);
        return ResponseEntity.status(201).body(savedCours); // 201 Created
    }

    @DeleteMapping("/matieres/{matiereId}/cours/{coursId}")
    public ResponseEntity<String> deleteCours(@PathVariable int matiereId, @PathVariable Long coursId) {
        try {
            matiereService.deleteCoursById(matiereId, coursId);
            return ResponseEntity.ok("Cours supprimé avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Cours non trouvé.");
        }
    }
//
//    @GetMapping("/matieres/{matiereId}/etudiants")
//    public List<Etudiant> getEtudiantsByMatiere(@PathVariable int matiereId) {
//        return matiereService.getEtudiantsByMatiereId(matiereId);
//    }
}
