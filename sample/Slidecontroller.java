package sample;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Slidecontroller implements Initializable {

    EsiMeal e;

    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton exit;





    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    void setesimeal(EsiMeal e){this.e=e;


    }


    public void login(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("Signin.fxml"));

            Parent root= loader.load();
            Signin controller =loader.<Signin>getController();
            controller.seteasimeal(e);

            Controller.main.getChildren().clear();
            Controller.main.getChildren().add(root);

        }catch (IOException e){}
    }

    public void Commande(MouseEvent mouseEvent) {

        try {
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("Commande_view.fxml"));

            Parent root= loader.load();
            CommandeView controller =loader.<CommandeView>getController();
            controller.setesimeal(e);
            Controller.main.getChildren().clear();
            Controller.main.getChildren().add(root);
        }catch (IOException e){}
    }

    public void Stock(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("Stock.fxml"));

            Parent root= loader.load();
            Stockcontroller controller =loader.<Stockcontroller>getController();
            controller.setesimeal(e);
            Controller.main.getChildren().clear();
            Controller.main.getChildren().add(root);

        }catch (IOException e){}
    }


    public void stat(MouseEvent mouseEvent) {

        try {

            FXMLLoader loader =  new FXMLLoader(getClass().getResource("Home.fxml"));
            Home controller =new Home(e);
            loader.setController(controller);
            Parent root= loader.load();


            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("stats.fxml"));

            Parent root2= loader2.load();
            Stats co = loader2.<Stats>getController();
            co.setesimeal(e);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Esi meal");

            primaryStage.setScene(new Scene(root2));
            primaryStage.show();


            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("effectue.fxml"));
            Effectue co2 = new Effectue(e);
            loader3.setController(co2);
            Parent root3= loader3.load();


            Stage primaryStage2 = new Stage();
            primaryStage2.setTitle("Esi meal");

            primaryStage2.setScene(new Scene(root3));
            primaryStage2.show();



            Controller.main.getChildren().clear();
            Controller.main.getChildren().add(root);





        }catch (IOException e){}
    }

    public void home(MouseEvent mouseEvent) {

        try {

            FXMLLoader loader =  new FXMLLoader(getClass().getResource("welcoming.fxml"));

            Parent root= loader.load();
            welcome co = loader.<welcome>getController();
            co.setesimeal(e);

            Controller.main.getChildren().clear();
            Controller.main.getChildren().add(root);



        }catch (IOException e){}
    }


}