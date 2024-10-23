package com.example.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "projets_academiques")
public class ProjetAcademique implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Enumerated(EnumType.STRING)
    private TypeProjet type; // Enum pour le type (PFA ou PFE)

    private String dateUniversitaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enseignant_id", nullable = false)
    @JsonIgnore // Ignorer si cela cause des problèmes de sérialisation
    private Enseignant enseignant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant_id")
    @JsonIgnore // Ignorer si cela cause des problèmes de sérialisation
    private Etudiant etudiant;

    @Enumerated(EnumType.STRING)
    private StatutProjet statut; // Enum pour le statut du projet

    private Date dateAffectation;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public TypeProjet getType() {
        return type;
    }

    public void setType(TypeProjet type) {
        this.type = type;
    }

    public String getDateUniversitaire() {
        return dateUniversitaire;
    }

    public void setDateUniversitaire(String dateUniversitaire) {
        this.dateUniversitaire = dateUniversitaire;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public StatutProjet getStatut() {
        return statut;
    }

    public void setStatut(StatutProjet statut) {
        this.statut = statut;
    }

    public Date getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(Date dateAffectation) {
        this.dateAffectation = dateAffectation;
    }

    // Enum pour le type de projet
    public enum TypeProjet {
        PFA,
        PFE
    }

    // Enum pour le statut du projet
    public enum StatutProjet {
        AFFECTE,
        EN_COURS,
        TERMINE
    }
}
