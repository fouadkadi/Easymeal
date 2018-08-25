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
public abstract class met extends Article implements Serializable {


    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    protected int dispo;
   public met( int dispo, int nbr, int pr, String nom)
   {
          
          super(nbr,pr,nom);
          this.dispo=dispo;
   }
}
