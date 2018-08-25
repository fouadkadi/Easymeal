package sample;

import javafx.event.ActionEvent;

public class welcome {
    EsiMeal e ;

    void setesimeal(EsiMeal e){this.e=e;}

    public void exit(ActionEvent actionEvent) {


        System.out.println(e);
        Main.saveclass(e);
        System.exit(0);
    }
}
