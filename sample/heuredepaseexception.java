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
public class heuredepaseexception extends Exception implements Serializable {
        public String getMessage()
{
       return "vous avez dépassé l'heure permise pout faire votre commande";
}
}
