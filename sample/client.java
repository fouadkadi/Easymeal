package sample;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author foufou
 */
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;
/**
 *
 * @author foufou
 */
public class client implements Serializable {
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Typeclient getType() {
        return type;
    }

    public void setType(Typeclient type) {
        this.type = type;
    }

    public TreeMap<LocalDateTime, Commande> getListe() {
        return Liste;
    }

    public void setListe(TreeMap<LocalDateTime, Commande> liste) {
        Liste = liste;
    }

    protected String nom ;
    protected String prenom;
    protected String num;
    protected Typeclient type;
    protected TreeMap<LocalDateTime,Commande> Liste = new TreeMap<LocalDateTime,Commande>() ;
    
    public client(String nom ,
     String prenom,
     String num,
     Typeclient type)
    {
        this.nom=nom;
        this.prenom= prenom;
        this.num=num;
        this.type=type;
    }
    
    
    int getnb_commande()
    {   
        return Liste.size();
         
    }
    
    void ajout_commande(LocalDateTime d ,Commande c )
    {
        Liste.put(d, c);
    }
    
  }
