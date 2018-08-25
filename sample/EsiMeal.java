package sample;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;
public class EsiMeal implements Serializable
{

    public ArrayList<clientfidel> getListeclientfidel() {
        return Listeclientfidel;
    }

    public void setListeclientfidel(ArrayList<clientfidel> listeclientfidel) {
        Listeclientfidel = listeclientfidel;
    }

    public ArrayList<client> getListclient() {
        return listclient;
    }

    public void setListclient(ArrayList<client> listclient) {
        this.listclient = listclient;
    }

    public ArrayList<Table> getListTables() {
        return listTables;
    }

    public void setListTables(ArrayList<Table> listTables) {
        this.listTables = listTables;
    }

    public ArrayList<Commande> getListcmdenAttente() {
        return listcmdenAttente;
    }

    public void setListcmdenAttente(ArrayList<Commande> listcmdenAttente) {
        this.listcmdenAttente = listcmdenAttente;
    }

    public ArrayList<Commande> getListcmdEffect() {
        return listcmdEffect;
    }

    public void setListcmdEffect(ArrayList<Commande> listcmdEffect) {
        this.listcmdEffect = listcmdEffect;
    }

    public ArrayList<repas> getListrepas() {
        return listrepas;
    }

    public void setListrepas(ArrayList<repas> listrepas) {
        this.listrepas = listrepas;
    }

    public ArrayList<Boisson> getListboisson() {
        return listboisson;
    }

    public void setListboisson(ArrayList<Boisson> listboisson) {
        this.listboisson = listboisson;
    }

    public ArrayList<Supplement> getListsup() {
        return listsup;
    }

    public void setListsup(ArrayList<Supplement> listsup) {
        this.listsup = listsup;
    }

    public HashSet<met> getListMet() {
        return listMet;
    }

    public void setListMet(HashSet<met> listMet) {
        this.listMet = listMet;
    }

    public int getNbrtable() {
        return nbrtable;
    }

    public void setNbrtable(int nbrtable) {
        this.nbrtable = nbrtable;
    }

    public int getNbrchaises() {
        return nbrchaises;
    }

    public void setNbrchaises(int nbrchaises) {
        this.nbrchaises = nbrchaises;
    }

    protected ArrayList<client> listclient = new ArrayList<>();
    protected ArrayList<clientfidel> Listeclientfidel= new ArrayList<>();
    protected ArrayList<Table> listTables = new ArrayList<>();
    protected ArrayList<Commande> listcmdenAttente = new ArrayList();
    protected ArrayList<Commande> listcmdEffect = new ArrayList<>();
    protected ArrayList<repas> listrepas = new ArrayList<>();
    protected ArrayList<Boisson> listboisson= new ArrayList<>();
    protected ArrayList<Supplement> listsup = new ArrayList<>();
    protected HashSet<met> listMet = new HashSet<>();
    int nbrtable;
    int nbrchaises;
     public  long NbrCmdEffect (LocalDateTime debut ,LocalDateTime fin)
     {
        long nombre = listcmdEffect.stream()
                
                .filter(x -> (x.heure.isAfter(debut) && x.heure.isBefore(fin)))
                .count();
        return nombre;
    }
     public  long NbrCmdSurPlace (LocalDateTime debut ,LocalDateTime fin)
     {
        long nombre =  listcmdEffect.stream()
                .filter(x -> x instanceof commande_surplace)
                .filter(x -> (x.heure.isAfter(debut) && x.heure.isBefore(fin)))
                .count();
        return nombre;
    }
    public double MontantCmdEffect (LocalDateTime debut ,LocalDateTime fin)
    {
        double montant = listcmdEffect.stream()
                .filter(x -> (x.heure.isAfter(debut) && x.heure.isBefore(fin)))
                .mapToDouble(x -> x.PrixFinale())
                .sum();
        return montant;
    }
         
     public  double MontantCmdSurPlace (LocalDateTime debut ,LocalDateTime fin)
     {
        double montant = listcmdEffect.stream()
                .filter(x -> x instanceof commande_surplace)
                .filter(x -> (x.heure.isAfter(debut) && x.heure.isBefore(fin)))
                .mapToDouble(x -> x.PrixFinale())
                .sum();
        return montant;
     }
     public  double MontantCmdDomicile (LocalDateTime debut ,LocalDateTime fin)
     {
        double montant = listcmdEffect.stream()
                .filter(x -> x instanceof commande_livré)
                .filter(x -> (x.heure.isAfter(debut) && x.heure.isBefore(fin)))
                .mapToDouble(x -> x.PrixFinale())
                .sum();
        return montant;
     }
     public  long NbrCmdDomicile (LocalDateTime debut ,LocalDateTime fin)
     {
        long nombre =  listcmdEffect.stream()
                .filter(x -> x instanceof commande_livré)
                .filter(x -> (x.heure.isAfter(debut) && x.heure.isBefore(fin)))
                .count();
        return nombre;
     }
     public  long NbrCmdEvenement (LocalDateTime debut ,LocalDateTime fin)
     {
        long nombre =  listcmdEffect.stream()
                .filter(x -> x instanceof Evenement)
                .filter(x -> (x.heure.isAfter(debut) && x.heure.isBefore(fin)))
                .count();
        return nombre;
     }

    public  double MontantCmdEvenement (LocalDateTime debut ,LocalDateTime fin)
    {
        double montant = listcmdEffect.stream()
                .filter(x -> x instanceof Evenement)
                .filter(x -> (x.heure.isAfter(debut) && x.heure.isBefore(fin)))
                .mapToDouble(x -> x.PrixFinale())
                .sum();
        return montant;
    }
     public  double MontantTotalReduction(LocalDateTime debut ,LocalDateTime fin)
     {
        double montant = listcmdEffect.stream()
                         .mapToDouble(x ->x.Prix() * x.ReductionTotale() )
                         .sum();
        return montant;
     }

    
    public  double MontantTotalReducFidelite (LocalDateTime debut ,LocalDateTime fin)
    {
        double montant = 0.0;
        for (Commande commande : listcmdEffect.parallelStream().filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin)).collect(Collectors.toList())) {
            montant += commande.listreduction.contains(0.05) ? commande.Prix() * 0.05 : 0.0;

        }
        return montant;
    }
        public  double MontantTotalReducEtudiant (LocalDateTime debut ,LocalDateTime fin)
        {
        double montant = 0.0;
        for (Commande commande : listcmdEffect.parallelStream().filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin)).collect(Collectors.toList())) {
            montant += commande.listreduction.contains(0.08) ? commande.Prix() * 0.08 : 0.0;

        }
        return montant;
    }

    public  double MontantTotalReducGroupe (LocalDateTime debut ,LocalDateTime fin) {
        double montant = 0.0;
        for (Commande commande : listcmdEffect.parallelStream().filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin)).collect(Collectors.toList())) {
            montant += commande.listreduction.contains(0.07) ? commande.Prix() * 0.07 : 0.0;

        }
        return montant;
    }

    public  double MontantTotalReducEvenm (LocalDateTime debut ,LocalDateTime fin) {
        double montant = 0.0;
        for (Commande commande : listcmdEffect.parallelStream().filter(x -> x instanceof Evenement).filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin)).collect(Collectors.toList())) {
            montant += commande.listreduction.contains(0.1) ? commande.Prix() * 0.1 : 0.0;

        }
        return montant;
    }
    public  String metLePlusCommande(LocalDateTime debut, LocalDateTime fin) {
        int nbcommande = 0 ;
        String nom = "";

        for (met met : listMet) {
            long nbCommandeMet = listcmdEffect
                    .stream()
                    .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                    .mapToLong(x -> x.nombreCommandeparMet(met.nom))
                    .sum();
            if (nbCommandeMet >= nbcommande) {
                nbcommande = nbcommande;
                nom = met.nom;
            }
        }
        return nom;
    }
    
    public String metLeMoinsCommande(LocalDateTime debut, LocalDateTime fin) {
        int nbcommande = 0 ;
        String nom = "";

        for (met met : listMet) {
            long nbCommandeMet = listcmdEffect
                    .stream()
                    .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                    .mapToLong(x -> x.nombreCommandeparMet(met.nom))
                    .sum();
            if (nbCommandeMet <= nbcommande) {
                nbcommande = nbcommande;
                nom = met.nom;
            }
        }
        return nom;
    }

   

    public client ClientPlusCommande (LocalDateTime debut, LocalDateTime fin) {
        long nbcommande = 0;
        client cli = null;

        for (client client : Listeclientfidel) {
            long nb = listcmdEffect
                      .stream()
                      .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                      .filter(x -> x.cli.equals(client))
                      .count();
            if (nb >= nbcommande) {
                nbcommande = nb;
                cli = client;
            }
        }
        return cli;
    }
    
    public  client ClientPlusAdomicle (LocalDateTime debut, LocalDateTime fin) {
        long nbcommande = 0;
        client cli = null;

        for (client client : Listeclientfidel) {
            long nb = listcmdEffect
                    .stream()
                    .filter(x -> x instanceof commande_livré)
                    .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                    .filter(x -> x.cli.equals(client))
                    .count();
            if (nb >= nbcommande) {
                nbcommande = nb;
                cli = client;
            }
        }
        return cli;
    }

    public  client ClientPlusSurplace (LocalDateTime debut, LocalDateTime fin) {
        long nbcommande = 0;
        client cli = null;

        for (client client : Listeclientfidel) {
            long nb = listcmdEffect
                    .stream()
                    .filter(x -> x instanceof commande_surplace)
                    .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                    .filter(x -> x.cli.equals(client))
                    .count();
            if (nb >= nbcommande) {
                nbcommande = nb;
                cli = client;
            }
        }
        return cli;
    }
    public client ClientPlusEvenement (LocalDateTime debut, LocalDateTime fin) {
        long nbcommande = 0;
        client cli = null;

        for (client client : Listeclientfidel) {
            long nb = listcmdEffect
                    .stream()
                    .filter(x -> x instanceof Evenement)
                    .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                    .filter(x -> x.cli.equals(client))
                    .count();
            //Verifie si le client courant a plus de commandes Evenements que le précédent.
            if (nb >= nbcommande) {
                nbcommande = nb;
                cli = client; //affecter le client courant au client qui a le plus de commande
            }
        }
        return cli;
    }

    public  client ClientPlusReductions (LocalDateTime debut, LocalDateTime fin) {
        long nbreduxmax = 0;
        client cli = null;
        long nbRedux = 0;
        for (client client : Listeclientfidel) {
            nbRedux = listcmdEffect
                      .stream()
                      .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                      .filter(x -> x.cli.equals(client))
                      .mapToLong(x -> x.listreduction.size()) //Avoir le nombre de reductions dans la commande
                      .sum();
            //Verifier si le client courant a plus de reductions que les précédents.
            if (nbRedux >= nbreduxmax)  {

                nbreduxmax = nbRedux;
                cli = client;
            }
        }
        return cli;
    }

    public client ClientPlusReducFidelite (LocalDateTime debut, LocalDateTime fin) {
        long nbreduxmax = 0;
        client cli = null;
        long nbRedux = 0;
        for (client client : Listeclientfidel) {
            if (client instanceof clientfidel) {
                nbRedux = listcmdEffect
                        .stream()
                        .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                        .filter(x -> x.cli.equals(client))
                        .count();
            }
            else  {
                nbRedux = 0;
            }
            //Verifier si le client courant a plus de reductions que les précédents.
            if (nbRedux >= nbreduxmax)
            {
                nbreduxmax = nbRedux;
                cli = client;
            }
        }
        return cli;
    }

    public client ClientPlusReducGroupe(LocalDateTime debut, LocalDateTime fin) {
        long nbreduxmax = 0;
        client cli = null;
        long nbRedux = 0;
        for (client client : Listeclientfidel) {

            nbRedux = listcmdEffect
                    .stream()
                    .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                    .filter(x -> x.cli.equals(client))
                    .filter(x -> x.listreduction.contains(0.07)) /*verifie si la liste contient une reduction groupe*/
                    .count();

            //Verifie si le client courant a plus de reductions que les précédents.
            if (nbRedux >= nbreduxmax)  {

                nbreduxmax = nbRedux;
                cli = client;
            }
        }
        return cli;
    }
    public client ClientPlusReducEtudiant (LocalDateTime debut, LocalDateTime fin) {
        long nbreduxmax = 0;
        client cli = null;
        long nbRedux = 0;
        for (client client : Listeclientfidel) {
            if (client.type.equals(Typeclient.Etudiant)) {
                nbRedux = listcmdEffect
                        .stream()
                        .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                        .filter(x -> x.cli.equals(client))
                        .count();
            }
            else  {
                nbRedux = 0;
            }
            //Verifie si le client courant a plus de reductions que les précédents.
            if (nbRedux >= nbreduxmax)  {

                nbreduxmax = nbRedux;
                cli = client;
            }
        }
        return cli;
    }
 
    public client ClientPlusReducEvenement(LocalDateTime debut, LocalDateTime fin) {
        long nbreduxmax = 0;
        client cli = null;
        long nbRedux = 0;
        for (client client : Listeclientfidel) {

            nbRedux = listcmdEffect
                    .stream()
                    .filter(x -> x instanceof Evenement)
                    .filter(x -> x.heure.isAfter(debut) && x.heure.isBefore(fin))
                    .filter(x -> x.cli.equals(client))
                    .filter(x -> x.listreduction.contains(0.1))
                    .count();

            //Verifie si le client courant a plus de reductions que les précédents.
            if (nbRedux >= nbreduxmax)  {

                nbreduxmax = nbRedux;
                cli = client;
            }
        }
        return cli;
    }

    //---------------------------------- Modification des informations ------------------------------------------------//


    public void modifclientfidel( String code ,String nom,String prenom ,String num,Typeclient type)
    {
        for (clientfidel client : Listeclientfidel)
        {
            if(client.getCode().equals(code)){  client.setNom(nom);client.setPrenom(prenom);client.setNum(num); client.setType(type);  }       }

    }


    public void modirepas( repas c ,int dispo, int nbr, int pr, String nom, Typerepas type ,String ing)
    {
        c.setIngredient(ing);
        c.setType(type);
        c.setDispo(dispo);
        c.setNbr_cal(nbr);
        c.setPrix(pr);
        c.setNom(nom);

    }

    public void modifboisson( Boisson c,int dispo, int nbr, int pr, String nom,TypeBoisson type,String marque, String gout)
    {

        c.setType(type);
        c.setDispo(dispo);
        c.setNbr_cal(nbr);
        c.setPrix(pr);
        c.setNom(nom);
        c.setGout(gout);
        c.setMarque(marque);

    }

    public void modifsupplement( Supplement c, int nbr, int pr, String nom)
    {


        c.setNbr_cal(nbr);
        c.setPrix(pr);
        c.setNom(nom);


    }

}
