package sample;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@SuppressWarnings("all")


public class Evenement extends Commande implements Serializable {
     
     private String thématique;
     private String decors;
     protected TypeEvennement type;
     private int nb_invite;

     
     public Evenement(   String thématique,String decors,int invité,client cli,String Num ,LocalDateTime heure ,
   int nb_persone ,TypeEvennement type)
     {
         super(cli,Num,heure,nb_persone);
         this.thématique= thématique ;
         this.decors=decors;
         this.type=type;

         this.nb_invite=this.nb_persone;         
         
         
         
     }
    
     @Override
     void ajout (Article m){ menu.add(m); }
     @Override
     void retirer(Article m){ menu.remove(m);}
     @Override
     void valider() throws Evenementnonvalidexception
     {
  
            LocalDateTime t = LocalDateTime.now();
            if(t.plusDays(15).isAfter(heure))
            {
                throw new Evenementnonvalidexception();
            }
            if(nb_invite<30 || nb_invite>80)
            {
                throw new Evenementnonvalidexception();             
            }

     }
     @Override
      double Prix()
      { 
         int p=0;
         
         p = menu.stream().map((e) -> e.prix).reduce(p, Integer::sum);
          return p;
          
          
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
        if(nb_invite<=50)
        {
            ReductionEvenement a=new ReductionEvenement();
            Prct+=a.donnerPourcentage(this, cli);
            listreduction.add(Prct+=a.donnerPourcentage(this, cli));
        }
        return Prct;
    }
       double PrixFinale()
       {
           return Prix()-(Prix()*ReductionTotale());
       }

  
    
}
