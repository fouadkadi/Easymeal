package sample;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;

public class Main extends Application {



    @Override

    public void start(Stage primaryStage) throws Exception{


        EsiMeal e;
        if(loadclass()==null){ e= new EsiMeal();

        }else {e= loadclass();}










        FXMLLoader page = new  FXMLLoader(getClass().getResource("sample.fxml"));


        Controller controller = new Controller(e);

        page.setController(controller);
        Parent root=page.load();

        primaryStage.setTitle("Esi meal");

        primaryStage.setScene(new Scene(root));
        primaryStage.show();










    }


    public static void main(String[] args) {
        launch(args);




    }

    //==========================================     Pour la serialisation     ===================================================//

    static public  void saveclass(EsiMeal e)
    {


        ObjectOutputStream out=null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Esimeal.dat"))));}catch (Exception s){}


       try {

           out.writeObject(e);
           out.close();

       }catch (IOException exceptiono){

       }


    }

    static public  EsiMeal loadclass() throws IOException, ClassNotFoundException {
        ObjectInputStream in=null;
        try {

            in  = new ObjectInputStream( new BufferedInputStream (new FileInputStream(new File("Esimeal.dat"))));

            return (EsiMeal)in.readObject();




        } catch (Exception e) {




        }
        try {
            in.close();
        }catch (Exception s){}

        return  null;
    }
}
