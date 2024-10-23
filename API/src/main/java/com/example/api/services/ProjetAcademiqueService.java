package com.example.api.services;

import com.example.api.models.ProjetAcademique;
import com.example.api.repositories.ProjetAcademiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetAcademiqueService {
    @Autowired
    private ProjetAcademiqueRepository projetAcademiqueRepository;

    public ProjetAcademique createProjet(ProjetAcademique projetAcademique) {
        return projetAcademiqueRepository.save(projetAcademique);
    }

    public List<ProjetAcademique> getProjetsByEnseignantId(int enseignantId) {
        return projetAcademiqueRepository.findByEnseignantId(enseignantId);
    }

    public void deleteProjet(Long id) {
        projetAcademiqueRepository.deleteById(id);
    }

}
