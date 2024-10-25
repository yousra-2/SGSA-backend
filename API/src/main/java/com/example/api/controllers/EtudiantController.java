package com.example.api.controllers;

import com.example.api.models.Etudiant;
import com.example.api.models.Matiere;
import com.example.api.models.Note;
import com.example.api.models.Module;

import com.example.api.repositories.EtudiantRepository;
import com.example.api.repositories.NoteRepository;
import com.example.api.repositories.ModuleRepository;
import com.example.api.repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RestController
@RequestMapping("/etudiants")
//@CrossOrigin(origins = "*")

public class EtudiantController {

//    @RequestMapping(method = RequestMethod.OPTIONS)
//    public ResponseEntity<?> handleOptionsRequest() {
//        return ResponseEntity.ok().build();
//    }

    @Autowired
    private NoteRepository noteRepository;


    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private MatiereRepository matiereRepository;

    // Méthode pour obtenir les modules et les notes d'un étudiant
    @GetMapping("/{etudiantId}/notes/modules")
    public ResponseEntity<List<Map<String, Object>>> getModulesWithNotes(@PathVariable Long etudiantId) {
        List<Module> modules = moduleRepository.findAll(); // Cela devrait maintenant fonctionner correctement
        List<Map<String, Object>> result = new ArrayList<>();

        for (Module module : modules) {
            Map<String, Object> moduleData = new HashMap<>();
            moduleData.put("moduleId", module.getId());
            moduleData.put("moduleNom", module.getNom());

            // Récupérer les matières du module
            List<Matiere> matieres = matiereRepository.findByModule_Id(module.getId());
            List<Double> notes = new ArrayList<>();

            for (Matiere matiere : matieres) {
                // Récupérer la note de l'étudiant pour chaque matière
                Optional<Note> matiereNote = noteRepository.findByEtudiant_IdAndMatiere_Id(etudiantId, matiere.getId());
                matiereNote.ifPresent(note -> notes.add(note.getValeur())); // Ajoute la valeur de la note si elle est présente
            }


            // Calculer la note moyenne pour le module
            if (!notes.isEmpty()) {
                // Calculer la note moyenne pour le module
                double moyenne = notes.stream().mapToDouble(Double::doubleValue).average().orElse(0);
                moduleData.put("moyenneNote", moyenne);
                result.add(moduleData);
            }
        }
        return ResponseEntity.ok(result);
    }



//    @GetMapping("/{etudiantId}/notes")
//    public ResponseEntity<List<Note>> getNotesByEtudiant(@PathVariable int etudiantId) {
//        // Récupérer l'étudiant par ID
//        Etudiant etudiant = etudiantRepository.findById(etudiantId)
//                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé avec id : " + etudiantId));
//
//        // Récupérer la liste des notes associées à l'étudiant
//        List<Note> notes = etudiant.getNotes();
//
//        return ResponseEntity.ok(notes);
//    }



//    @GetMapping("/{etudiantId}/notes")
//    public ResponseEntity<List<Note>> getNotesByEtudiantWithMatiere(@PathVariable Long etudiantId) {
//        // Utilisation de la méthode personnalisée pour récupérer les notes avec les matières
//        List<Note> notes = noteRepository.findNotesByEtudiantWithMatiere(etudiantId);
//
//        // Retourne les notes sous forme de réponse HTTP
//        return ResponseEntity.ok(notes);
//    }
//    public ResponseEntity<List<Object[]>> getNotesByEtudiantWithMatiere(@PathVariable Long etudiantId) {
//        // Utilisation de la méthode personnalisée pour récupérer les notes avec les matières
//        List<Object[]> notes = noteRepository.findNotesByEtudiantWithMatiere(etudiantId);
//
//        // Retourne les notes sous forme de réponse HTTP
//        return ResponseEntity.ok(notes);
//    }


}
