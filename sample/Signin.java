package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.*;

public class Signin   {

    EsiMeal e;
    public JFXTextField prenom;
    public JFXTextField nom;
    public JFXTextField num;
    public JFXComboBox function;
    public JFXDialog dialoge;
    public Label message;


   void  seteasimeal(EsiMeal e){ this.e=e; }

    public void submit(ActionEvent actionEvent) throws IOException {
         clientfidel f = new clientfidel(nom.getText(),prenom.getText(),num.getText(),Typeclient.valueOf(function.getValue().toString()));


         e.Listeclientfidel.add(f);







     System.out.println("Votre code fidèlité est :"+"  "+f.code);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("Votre code fidèlité est :"+"  "+f.code);

        alert.showAndWait();

    }
}
