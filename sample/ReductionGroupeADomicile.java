/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sg
 */
public class ReductionGroupeADomicile implements Reduction,Serializable {

    @Override
    public double donnerPourcentage(Commande commande, client client) 
    {
          if(commande.nb_persone>=4 && commande.getClass().getSimpleName().equals("commande_livré"))
                
            {
                return 0.07;
                
            }
            else return 0;
        
    }
}