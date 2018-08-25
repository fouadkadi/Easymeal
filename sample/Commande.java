package sample;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Commande implements Serializable {

    public client getCli() {
        return cli;
    }

    public void setCli(client cli) {
        this.cli = cli;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    public LocalDateTime getHeure() {
        return heure;
    }

    public void setHeure(LocalDateTime heure) {
        this.heure = heure;
    }

    public ArrayList<Article> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Article> menu) {
        this.menu = menu;
    }

    public ArrayList<Double> getListreduction() {
        return listreduction;
    }

    public void setListreduction(ArrayList<Double> listreduction) {
        this.listreduction = listreduction;
    }

    public int getNb_persone() {
        return nb_persone;
    }

    public void setNb_persone(int nb_persone) {
        this.nb_persone = nb_persone;
    }

    protected client cli;
    protected String Num ;
    protected LocalDateTime heure ;/*consommation*/
    protected ArrayList<Article> menu = new ArrayList<Article>() ;
    protected ArrayList<Double> listreduction = new ArrayList<>();
    protected int nb_persone;  
    abstract void ajout (Article m);
    abstract void retirer(Article m);
    abstract void valider() throws heuredepaseexception,Evenementnonvalidexception,Distancenonvalidexception;
    abstract double Prix();
    abstract double PrixFinale();
   public Commande(client cli, String Num, LocalDateTime heure, int nb_personne)
   {
       this.cli=cli;
       this.Num=Num;
       this.heure=heure;
       this.nb_persone=nb_personne; 
   }
   
 public int nombreCommandeparMet(String nm)
 {
     int nbr=0;
     for (Article m: menu)
     {
         if(m.nom.equals(nm)) nbr++;
     }
     return nbr;
 }  
  public double ReductionTotale() {
        double Prct=0.0;
        if (cli.type.equals(Typeclient.Etudiant))
        {
            ReductionEtudiant a=new ReductionEtudiant();
            Prct=a.donnerPourcentage(this, cli);
            listreduction.add(a.donnerPourcentage(this, cli));
        }
        if (cli instanceof clientfidel)
        {
            ReductionFidelité a= new ReductionFidelité();         
            Prct+=a.donnerPourcentage(this, cli); 
            listreduction.add(a.donnerPourcentage(this, cli));
        }
        return Prct;
    }
}
