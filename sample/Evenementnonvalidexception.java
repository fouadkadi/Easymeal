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
public class Evenementnonvalidexception extends Exception implements Serializable {
    
        public String getMessage()
{
        return "nombre de place doit etre entre 30 et 80";
}
    
}
