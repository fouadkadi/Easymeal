/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;

public class Table implements Serializable {
    public int getNbrchaise() {
        return nbrchaise;
    }

    public void setNbrchaise(int nbrchaise) {
        this.nbrchaise = nbrchaise;
    }

    public TypeTable getTypetabla() {
        return typetabla;
    }

    public void setTypetabla(TypeTable typetabla) {
        this.typetabla = typetabla;
    }

    public HashSet<LocalDateTime> getProgramme() {
        return programme;
    }

    public void setProgramme(HashSet<LocalDateTime> programme) {
        this.programme = programme;
    }

    int nbrchaise;
    TypeTable typetabla;

    public Table(int nb , TypeTable t){ this.nbrchaise=nb;this.typetabla=t; }
    public TypeTable gettype()
    {
        return typetabla;
    }   
    HashSet<LocalDateTime> programme; 
    boolean estlibre(LocalDateTime c)
    {
        for(LocalDateTime time: programme)
        {
            if(c.isEqual(time) || c.minusHours(1).isEqual(time) || c.plusHours(1).isEqual(time))
                return false;
        }
        return true;
    }
    void reserver (LocalDateTime c2)
    {
        if(estlibre(c2))
        programme.add(c2) ;

    }
}
