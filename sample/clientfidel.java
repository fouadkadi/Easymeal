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
public class clientfidel extends client implements Serializable {
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    protected String code;
    public clientfidel(String nom, String prenom, String num, Typeclient type) {
        super(nom, prenom, num, type);
        cree_code();
        
    }
    
    private void cree_code()
    {
       code=nom.substring(0,1)+prenom.substring(0,1)+num;
    }
}
