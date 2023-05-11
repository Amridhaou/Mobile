/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;

public class Cours {
    private int code_cours;
    private String nomination;
    private String type;
    private String support;
    private int duree;
    private String matiere;
    private String sujet;
    private int nbParticipants;
    private String datePublication;
    private String tuteur;
    private String contact;
    private Date updatedAt;

    public Cours(int code_cours, String nomination, String type, String support, int duree, String matiere, String sujet, int nbParticipants, String datePublication, String tuteur, String contact, Date updatedAt) {
        this.code_cours = code_cours;
        this.nomination = nomination;
        this.type = type;
        this.support = support;
        this.duree = duree;
        this.matiere = matiere;
        this.sujet = sujet;
        this.nbParticipants = nbParticipants;
        this.datePublication = datePublication;
        this.tuteur = tuteur;
        this.contact = contact;
        this.updatedAt = updatedAt;
    }

    public Cours() {
    }

    public Cours(String nomination, String type, String support, int duree, String matiere, String sujet, int nbParticipants, String datePublication, String tuteur, String contact, Date updatedAt) {
        this.nomination = nomination;
        this.type = type;
        this.support = support;
        this.duree = duree;
        this.matiere = matiere;
        this.sujet = sujet;
        this.nbParticipants = nbParticipants;
        this.datePublication = datePublication;
        this.tuteur = tuteur;
        this.contact = contact;
        this.updatedAt = updatedAt;
    }

    public int getCode_cours() {
        return code_cours;
    }

    public void setCode_cours(int code_cours) {
        this.code_cours = code_cours;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }

    public Cours(String nomination, String type, int duree, String matiere, String tuteur) {
        this.nomination = nomination;
        this.type = type;
        this.duree = duree;
        this.matiere = matiere;
        this.tuteur = tuteur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public int getNbParticipants() {
        return nbParticipants;
    }

    public void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Cours{" + "nomination=" + nomination + ", type=" + type + ", duree=" + duree + ", matiere=" + matiere + ", datePublication=" + datePublication + ", tuteur=" + tuteur + ", contact=" + contact + '}';
    }
    
    
}
