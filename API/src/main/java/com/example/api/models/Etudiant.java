package com.example.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "etudiants")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;  // Nouveau champ username

    private String password;
    private String phone;
    private String niveau_etude;
    private String code_appogee;
    private Date date_inscription  ;
//    @Column(nullable = false)
//    private String role; // Champ pour le rôle

    @OneToMany(mappedBy = "etudiant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore // Prevent serialization
    private List<Note> notes; // Notes associées à l'étudiant

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public String getProgramme() {
//        return programme;
//    }
//
//    public void setProgramme(String programme) {
//        this.programme = programme;
//    }

//    public String getRole() {
//        return role; // Getter pour le rôle
//    }
//
//    public void setRole(String role) {
//        this.role = role; // Setter pour le rôle
//    }
public String getNiveau_etude() {
    return niveau_etude;
}

    public void setNiveau_etude(String niveau_etude) {
        this.niveau_etude = niveau_etude;
    }
    public String getCode_appogee() {
        return code_appogee;
    }

    public void setCode_appogee(String code_appogee) {
        this.code_appogee = code_appogee;
    }
    public Date getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(Date date_inscription) {
        this.date_inscription = date_inscription;
    }

}
