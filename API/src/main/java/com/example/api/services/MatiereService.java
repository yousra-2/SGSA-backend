package com.example.api.services;

import com.example.api.models.Cours;
import com.example.api.models.Etudiant;
import com.example.api.models.Matiere;
import com.example.api.repositories.MatiereRepository;
import com.example.api.repositories.CoursRepository; // Assurez-vous d'importer CoursRepository
import com.example.api.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService {

    private final MatiereRepository matiereRepository;
    private final CoursRepository coursRepository; // Ajoutez cette ligne

    public MatiereService(MatiereRepository matiereRepository, CoursRepository coursRepository) {
        this.matiereRepository = matiereRepository;
        this.coursRepository = coursRepository; // Ajoutez cette ligne
    }

    // Méthode pour récupérer les noms des matières par l'ID de l'enseignant
    public List<String> findMatiereNamesByEnseignantId(int enseignantId) {
        return matiereRepository.findMatiereNamesByEnseignant_Id(enseignantId);
    }

    // Méthode pour récupérer les noms et contenus des cours d'une matière
    public List<Object[]> findCoursNamesAndContentsByMatiereId(int matiereId) {
        return matiereRepository.findCoursNamesAndContentsByMatiereId(matiereId);
    }
    public Optional<Matiere> findById(int id) {
        return matiereRepository.findById(id); // Méthode pour trouver une matière par ID
    }

    // Méthode pour ajouter un cours à une matière
    public Cours addCoursToMatiere(int matiereId, Cours cours) {
        // Trouver la matière par ID
        Matiere matiere = matiereRepository.findById(matiereId)
                .orElseThrow(() -> new RuntimeException("Matière non trouvée"));

        // Associer le cours à la matière
        cours.setMatiere(matiere);

        // Enregistrer le cours
        return coursRepository.save(cours);
    }
    public void deleteCoursById(int matiereId, Long coursId) {
        // Vérifiez d'abord si le cours existe et s'il appartient à la matière
        if (coursRepository.existsById(Math.toIntExact(coursId))) {
            coursRepository.deleteById(Math.toIntExact(coursId));
        } else {
            throw new RuntimeException("Cours non trouvé");
}
}
//    @Autowired
//    private MatiereRepository matiereRepository;

//    @Autowired
//    private NoteRepository noteRepository;
//
//    public List<Etudiant> getEtudiantsByMatiereId(int matiereId) {
//        // Récupérer la matière par ID
//        Matiere matiere = matiereRepository.findById(matiereId)
//                .orElseThrow(() -> new RuntimeException("Matière non trouvée"));
//
//        // Récupérer la liste des notes associées à cette matière
//        return noteRepository.findEtudiantsByMatiere(matiere);
//    }
}