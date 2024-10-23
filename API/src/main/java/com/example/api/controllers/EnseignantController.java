//package com.example.api.controllers;//package com.example.api.controllers;
////
////import com.example.api.models.Matiere;
////import com.example.api.repositories.MatiereRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.bind.annotation.CrossOrigin;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////import java.util.List;
////
////@RestController
////@RequestMapping("/enseignants")
////@CrossOrigin(origins = "http://localhost:4200")
////public class EnseignantController {
////
////    @Autowired
////    private MatiereRepository matiereRepository;
////
////    // Endpoint pour récupérer les matières d'un enseignant
////    @GetMapping("/{id}/matieres")
////    public ResponseEntity<List<Matiere>> getMatieresByEnseignantId(@PathVariable int id) {
////        List<Matiere> matieres = matiereRepository.findByEnseignantId(id);
////        if (matieres.isEmpty()) {
////            return ResponseEntity.notFound().build();
////        }
////        return ResponseEntity.ok(matieres);
////    }
////}
//
//import com.example.api.models.Matiere;
//import com.example.api.services.MatiereService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/enseignants")
//@CrossOrigin(origins = "http://localhost:4200")
//public class EnseignantController {
//
//    private final MatiereService matiereService;
//
//    public EnseignantController(MatiereService matiereService) {
//        this.matiereService = matiereService;
//    }
//
//    @GetMapping("/{id}/matieres")
//    public ResponseEntity<List<Matiere>> getMatieresByEnseignantId(@PathVariable int id) {
//        List<Matiere> matieres = matiereService.findMatieresByEnseignantId(id);
//        if (matieres == null || matieres.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return ResponseEntity.ok(matieres);
//    }
//}
