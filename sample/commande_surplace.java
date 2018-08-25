package sample;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class commande_surplace extends Commande implements Serializable {

    public TypeTable getTt() {
        return tt;
    }

    public void setTt(TypeTable tt) {
        this.tt = tt;
    }

    protected TypeTable tt;
    public commande_surplace (TypeTable ext,client cli,
    String Num ,
    LocalDateTime heure ,   
    int nb_persone)
    {
        super(cli,Num,heure,nb_persone);
        this.tt=ext;
    }
     void ajout (Article m){ menu.add(m); }
     void retirer(Article m){ menu.remove(m);}

    @Override
    void valider() throws heuredepaseexception, Evenementnonvalidexception, Distancenonvalidexception {

    }

    void valider(ArrayList<Table> list,TypeTable type) throws heuredepaseexception
     {
         int i=0;
             TypeTable tp;
         LocalDateTime t = LocalDateTime.now();
         if(t.plusHours(1).isAfter(heure))
         {
             throw new heuredepaseexception();
         }
         if (heure.getHour()>=22)
         {
             throw new heuredepaseexception();
         }

     }
      double Prix()
      { 
         int p=0;
         
          for(Article e:menu)
          {
              p+=e.prix;
          }
          if(tt.equals(TypeTable.exterieur))
          return (p+(p*5/100));
          else return p;
          
          
      }
     public double ReductionTotale() {
        double Prct=0.0;
       if (cli.type.equals(Typeclient.Etudiant))
        {   ReductionEtudiant a=new ReductionEtudiant();
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
      double PrixFinale()
       {
           return Prix()-(Prix()*ReductionTotale());
       }

  
}
