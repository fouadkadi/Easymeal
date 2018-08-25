package sample;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

import java.time.LocalDateTime;

public class Stats {

    public ListView list;
    EsiMeal e;
    public JFXTimePicker td;
    public JFXDatePicker dd;
    public JFXTimePicker tf;
    public JFXDatePicker df;


    void setesimeal(EsiMeal e){this.e=e;
        System.out.println(e);}
    public void requete(ActionEvent actionEvent) {

        System.out.println(e.listcmdenAttente.size()+"size");
        LocalDateTime debut = LocalDateTime.of(dd.getValue(),td.getValue());
        LocalDateTime fin = LocalDateTime.of(df.getValue(),tf.getValue());

        list.getItems().add("Nombre de commandes effectuées est : "+String.valueOf( e.NbrCmdEffect(debut,fin)));
        list.getItems().add("Montant des commandes effectuées est : "+String.valueOf( e.MontantCmdEffect(debut,fin)));
        list.getItems().add("Nombre des commandes effectuées sur place est : "+String.valueOf( e.NbrCmdSurPlace(debut,fin)));
        list.getItems().add("Montant des commandes effectuées sur place est : "+String.valueOf( e.MontantCmdSurPlace(debut,fin)));
        list.getItems().add("Nombre de commandes effectuées à domicile est : "+String.valueOf( e.NbrCmdDomicile(debut,fin)));
        list.getItems().add("Nombre de commandes de type événement effectuées est : "+String.valueOf( e.NbrCmdEvenement(debut,fin)));
        list.getItems().add("Montant total des réductions offertes: "+String.valueOf( e.MontantTotalReduction(debut,fin)));
        list.getItems().add("Montant total des réductions de type fidélité est: "+String.valueOf( e.MontantTotalReducFidelite(debut,fin)));
        list.getItems().add("Montant total des réductions de type étudiant est: "+String.valueOf( e.MontantTotalReducEtudiant(debut,fin)));
        list.getItems().add("Montant total des réductions de type groupe à domicile est: "+String.valueOf( e.MontantTotalReducGroupe(debut,fin)));
        list.getItems().add("Montant total des réductions de type événement est: "+String.valueOf( e.MontantTotalReducEvenm(debut,fin)));
        list.getItems().add("Met le plus commandé est: "+String.valueOf( e.metLePlusCommande(debut,fin)));
        list.getItems().add("Met le moins commandé est: "+String.valueOf( e.metLeMoinsCommande(debut,fin)));
        list.getItems().add("Client ayant effectué le plus de commande est: "+String.valueOf( e.ClientPlusCommande(debut,fin).nom));
        list.getItems().add("Client ayant effectué le plus de commandes sur place est : "+String.valueOf( e.ClientPlusSurplace(debut,fin).nom));
        list.getItems().add("Client ayant effectué le plus de commandes à domicile est : "+String.valueOf( e.ClientPlusAdomicle(debut,fin).nom));
        list.getItems().add("Client ayant effectué le plus de commandes de type évenement est : "+String.valueOf( e.ClientPlusEvenement(debut,fin).nom));
        list.getItems().add("Client ayant bénéficié du plus grand nombre de réductions est : "+String.valueOf( e.ClientPlusReductions(debut,fin).nom));
        list.getItems().add("Client ayant bénéficié du plus grand nombre de réduction de type fidélité est : "+String.valueOf( e.ClientPlusReducFidelite(debut,fin).nom));
        list.getItems().add("Client ayant bénéficié du plus grand nombre de réduction de type étudiant est : "+String.valueOf( e.ClientPlusReducEtudiant(debut,fin).nom));
        list.getItems().add("Client ayant bénéficié du plus grand nombre de réduction de type groupe à domicile est : "+String.valueOf( e.ClientPlusReducGroupe(debut,fin).nom));
        list.getItems().add("Client ayant bénéficié du plus grand nombre de réduction de type événement est : "+String.valueOf( e.ClientPlusReducEvenement(debut,fin).nom));






    }


}
