package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Controller implements Initializable {
    EsiMeal e ;
    public Label user;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private AnchorPane root;
    @FXML
    VBox  container;

    public static AnchorPane rootP;
    public  static  VBox main;



    void setesimeal(EsiMeal e ){this.e=e; }

    public  Controller(EsiMeal e){this.e=e;}
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        rootP = root;
        main=container;

        try {


            FXMLLoader loader  =  new FXMLLoader(getClass().getResource("Slidemenu.fxml"));
            FXMLLoader loader2  =  new FXMLLoader(getClass().getResource("welcoming.fxml"));

            VBox box=loader.load();
            main.getChildren().add(loader2.load());
            welcome co = loader2.<welcome>getController();
            co.setesimeal(e);
            Slidecontroller controller = loader.<Slidecontroller>getController();
            controller.setesimeal(e);
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }



        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);

        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();

            if(drawer.isOpened())
            {
                drawer.close();
            }else
                drawer.open();
        });
    }

    @FXML
    void click()
    {


    }





















}



