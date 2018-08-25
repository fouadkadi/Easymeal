/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.Serializable;

/**
 *
 * @author sg
 */
public class ReductionEvenement implements Reduction ,Serializable {

    @Override
    public double donnerPourcentage(Commande commande, client client) {
        if(commande.nb_persone>50 && commande instanceof Evenement)
        {
            return 0.1;
        }
        else return 0;
    }
    
}
