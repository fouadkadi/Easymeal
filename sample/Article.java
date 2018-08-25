package sample;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author sg
 */
public abstract class Article implements Serializable {
    public int getNbr_cal() {
        return nbr_cal;
    }

    public void setNbr_cal(int nbr_cal) {
        this.nbr_cal = nbr_cal;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    protected int nbr_cal, prix;
    protected String nom;
    public Article(int nbr, int pr, String nom)
    {
        nbr_cal=nbr;
        prix=pr;
        this.nom=nom;   
    }    
}
