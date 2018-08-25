package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.sun.security.ntlm.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Commandcontroller {

    public JFXTextField d_num;
    public JFXTimePicker d_time;
    public JFXTextField d_nember;
    public JFXTextField d_distance;
    public JFXTextField d_adr;
    public JFXTextField p_num;
    public JFXTimePicker p_time;
    public JFXTextField p_nbper;
    public JFXComboBox p_table;
    public JFXTextField e_num;
    public JFXTimePicker e_time;
    public JFXDatePicker e_date;
    public JFXTextField e_nbper;
    public JFXTextField e_tema;
    public JFXTextField e_dec;
    public JFXComboBox e_type;
    client c=null;
    EsiMeal e;

    void setclient(EsiMeal e,client c){this.c=c; this.e=e;}
    
    public void commandeadomicile(ActionEvent actionEvent) throws IOException {
        boolean test=false;
        LocalDate date = LocalDate.now();
        LocalTime time = d_time.getValue();

        LocalDateTime dateTime =  LocalDateTime.of(date, time);


        commande_livré com = new commande_livré(d_adr.getText(),c,d_num.getText(), dateTime,Integer.parseInt(d_nember.getText()),Integer.parseInt(d_distance.getText()));

        try {
            com.valider();
        }catch (heuredepaseexception ex)
        { test=true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());

            alert.showAndWait();


        }
        catch (Distancenonvalidexception exi)
        {   test=true;
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Message");
            alert2.setHeaderText(null);
            alert2.setContentText(exi.getMessage());

            alert2.showAndWait();
        }

        if (!test)
        {

            FXMLLoader page = new  FXMLLoader(getClass().getResource("Panier.fxml"));


            Panier controller = new Panier(e,com,c);

            page.setController(controller);
            Parent root=page.load();

            Stage primaryStage = new Stage();
            primaryStage.setTitle("Esi meal");

            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }


    }

    public void commandeasurpalce(ActionEvent actionEvent) throws IOException {

        boolean test=false;
        LocalDate date = LocalDate.now();
        LocalTime time = p_time.getValue();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        commande_surplace com = new commande_surplace(TypeTable.valueOf(p_table.getValue().toString()),c,p_num.getText(), dateTime,Integer.parseInt(p_nbper.getText()));

        try {
            com.valider(e.listTables,TypeTable.valueOf(p_table.getValue().toString()));
        }catch (heuredepaseexception ex)
        { test=true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());

            alert.showAndWait();


        }


        if (!test)
        {
            FXMLLoader page = new  FXMLLoader(getClass().getResource("Panier.fxml"));


            Panier controller = new Panier(e,com,c);

            page.setController(controller);
            Parent root=page.load();

            Stage primaryStage = new Stage();
            primaryStage.setTitle("Esi meal");

            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        }
    }

    public void commandeevent(ActionEvent actionEvent) throws IOException {
        boolean test=false;
        LocalDate date = e_date.getValue();
        LocalTime time = e_time.getValue();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Evenement com = new Evenement(e_tema.getText(),e_dec.getText(),Integer.parseInt(e_nbper.getText()),c, e_num.getText(),dateTime,Integer.parseInt(e_nbper.getText()),TypeEvennement.valueOf(e_type.getValue().toString()));

        try {
            com.valider();
        }catch (Evenementnonvalidexception ex)
        { test=true;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());

            alert.showAndWait();


        }


        if (!test)
        {
            FXMLLoader page = new  FXMLLoader(getClass().getResource("Panier.fxml"));


            Panier controller = new Panier(e,com,c);

            page.setController(controller);
            Parent root=page.load();

            Stage primaryStage = new Stage();
            primaryStage.setTitle("Esi meal");

            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        }

        
    }
}
