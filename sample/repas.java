package sample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sg
 */
public class repas extends met implements Serializable {
    public Typerepas getType() {
        return type;
    }

    public void setType(Typerepas type) {
        this.type = type;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public ArrayList<Supplement> getSup() {
        return sup;
    }

    public void setSup(ArrayList<Supplement> sup) {
        this.sup = sup;
    }

    protected Typerepas type;
    protected String ingredient;
    protected ArrayList<Supplement> sup = new ArrayList<>();

        public repas(int dispo, int nbr, int pr, String nom, Typerepas type ,String ing)
        {
            super(dispo, nbr,pr,nom);
            this.type=type;
            this.ingredient=ing;
        }
    
    
}
