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
public interface Reduction  extends Serializable {
   public abstract double donnerPourcentage(Commande commande, client client);
                          
}
