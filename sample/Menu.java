package sample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author sg
 */
public class Menu implements Serializable {
    public ArrayList<met> getMenuu() {
        return menuu;
    }

    public void setMenuu(ArrayList<met> menuu) {
        this.menuu = menuu;
    }

    public int getNbr_met() {
        return nbr_met;
    }

    public void setNbr_met(int nbr_met) {
        this.nbr_met = nbr_met;
    }

    private ArrayList<met> menuu=new ArrayList<>();
    private int nbr_met;
    
    
    public void ajout(met m){
       menuu.add(m);
       
    }
    public void supprimer (met m){
       menuu.remove(m);
    }
    public int calcul_calor(){ 
        int x=0;
        for(met m : menuu) {
           x+=m.nbr_cal;
          
        }
        return x;
    }
    public int getnbr_met(){
    return nbr_met;
    }
    public void setnbr_met(int n){
    nbr_met=n;}
    
}
