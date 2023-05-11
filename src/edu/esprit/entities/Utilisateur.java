/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author Lenovo
 */
//taw n7oto fi description
public class Utilisateur { 
    private int id;
    private String specialite_id;
    private String email;
    private String roles;
    private String motdepasse;
    private String nom;
    private String prenom;
    private String image;
    private String numero;
    private String status;

    public Utilisateur(int id, String specialite_id, String email, String roles, String motdepasse, String nom, String prenom, String image, String numero, String status) {
        this.id = id;
        this.specialite_id = specialite_id;
        this.email = email;
        this.roles = roles;
        this.motdepasse = motdepasse;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.numero = numero;
        this.status = status;
    }

    public Utilisateur(String email, String motdepasse) {
        this.email = email;
        this.motdepasse = motdepasse;
    }

    public Utilisateur(int id, String specialite_id, String email, String roles, String nom, String prenom, String image, String numero) {
        this.id = id;
        this.specialite_id = specialite_id;
        this.email = email;
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.numero = numero;
    }

    public Utilisateur(String specialite_id, String email, String roles, String nom, String prenom, String image, String numero) {
        this.specialite_id = specialite_id;
        this.email = email;
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialite_id() {
        return specialite_id;
    }

    public void setSpecialite_id(String specialite_id) {
        this.specialite_id = specialite_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "specialite_id=" + specialite_id + ", email=" + email + ", roles=" + roles + ", nom=" + nom + ", prenom=" + prenom + ", image=" + image + ", numero=" + numero + ", status=" + status + '}';
    }
    
}