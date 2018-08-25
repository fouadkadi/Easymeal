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
public class Supplement extends Article implements Serializable {
    public Supplement(int nbr, int pr, String nom){
    super(nbr,pr,nom);
    }
    
}
