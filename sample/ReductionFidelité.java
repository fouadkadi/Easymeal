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
public class ReductionFidelité implements Reduction,Serializable {

    @Override
    public double  donnerPourcentage(Commande commande, client cli) {
        
        if(cli.getnb_commande()>=2 && cli instanceof clientfidel)
        {
            return 0.05;
        }
       else return 0;
    }
    
}
