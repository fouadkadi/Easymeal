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
public class Distancenonvalidexception extends Exception implements Serializable {
    
    public String getMessage()
{
        return "Distance supérieur a 20km";
}
}
