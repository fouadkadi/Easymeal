/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.Serializable;

/**
 *
 * @author foufou
 */
public class commandenonvalidexception extends Exception implements Serializable
{
        public commandenonvalidexception()
{
        System.out.println("Vous ne pouvez pas faire une commande moin d'une heure avant la consommation");
}
    
}
