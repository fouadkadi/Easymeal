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
public class Boisson extends met implements Serializable {

 public TypeBoisson getType() {
  return type;
 }

 public void setType(TypeBoisson type) {
  this.type = type;
 }

 public String getMarque() {
  return marque;
 }

 public void setMarque(String marque) {
  this.marque = marque;
 }

 public String getGout() {
  return gout;
 }

 public void setGout(String gout) {
  this.gout = gout;
 }

 protected TypeBoisson type;
    protected String marque;
    protected String gout;
    
    public Boisson (int dispo, int nbr, int pr, String nom,TypeBoisson type,String marque, String gout)
            
    {
    super(dispo, nbr,pr,nom);
    this.type=type;
    this.marque=marque;
    this.gout=gout;
    }
    
    
}
