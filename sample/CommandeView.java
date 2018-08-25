package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class CommandeView {
    public JFXTextField nom;
    public JFXTextField prenom;
    public JFXTextField num;
    public JFXComboBox function;
    EsiMeal e;
    public JFXTextField codefidel;

    void setesimeal(EsiMeal e){ this.e=e;}


    public void clientfidel(ActionEvent actionEvent) throws IOException {

        clientfidel c = getfidel(codefidel.getText());
        if(c==null)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("ce client n'existe pas");

            alert.showAndWait();
        }else
            {
                FXMLLoader page = new  FXMLLoader(getClass().getResource("Commande.fxml"));



                Parent root=page.load();
                Commandcontroller con =page.<Commandcontroller>getController();
                con.setclient(e,c);

                Stage primaryStage = new Stage();
                primaryStage.setTitle("Esi meal");

                primaryStage.setScene(new Scene(root));
                primaryStage.show();

        }




    }

    public void clientnonfidel(ActionEvent actionEvent) throws IOException {
        client c = new client(nom.getText(),prenom.getText(),num.getText(),Typeclient.valueOf(function.getValue().toString()));
        e.listclient.add(c);
        FXMLLoader page = new  FXMLLoader(getClass().getResource("Commande.fxml"));



        Parent root=page.load();
        Commandcontroller con =page.<Commandcontroller>getController();
        con.setclient(e,c);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Esi meal");

        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    private clientfidel getfidel( String code )
    {
        for (clientfidel c : e.Listeclientfidel             ) {

            if(c.code.equals(code)) return c;

        }
        return null;
    }


}
