package sample;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author foufou
 */
public class commande_livré extends Commande implements Serializable {
    
    protected String Adr;
    protected int nbkilo;
    public commande_livré (String Adr,client cli,
    String Num ,
    LocalDateTime heure ,   
    int nb_persone, int nbkilo)
    {
        super(cli,Num,heure,nb_persone);
        this.Adr=Adr;
        this.nbkilo=nbkilo;
    }
    
    @Override
     void ajout (Article m){ menu.add(m); }
    @Override
     void retirer(Article m){ menu.remove(m);}
     void valider()  throws heuredepaseexception,Distancenonvalidexception
     {        
         
            LocalDateTime t = LocalDateTime.now();
            System.out.println(heure);
            if(t.plusMinutes(90).isAfter(heure)){

                throw new heuredepaseexception();}
            
            if (heure.isAfter(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT)))
            {

                throw new heuredepaseexception();
            }
            if (nbkilo>20) 
            {

                throw new Distancenonvalidexception();
            }
               
      }
    @Override   
      double Prix()
      { 
      
         int p=0;        
         for(Article e:menu)
          {
              p+=e.prix;
          }
          return (p+(20*nbkilo));
       
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
        if(nb_persone>=4)
        {
            ReductionGroupeADomicile a= new ReductionGroupeADomicile(); 
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
