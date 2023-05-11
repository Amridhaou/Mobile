/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Reclamation {
    //nemchio taw nchofo entity fi symfony
    
    private int id;
    private String type,description;
    private String date;
    private int etat;

    public Reclamation() {
    }

    
    
    
    public Reclamation(int id, String type, String description, String date, int etat) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.date = date;
        this.etat = etat;
    }

    public Reclamation(String type, String description, String date, int etat ,int iduser ) {
        this.type = type;
        this.description = description;
        this.date = date;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    }
