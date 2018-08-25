package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class Stockcontroller {
    public JFXTextField T_nom;
    public JFXComboBox T_type;
    EsiMeal e ;
    public JFXTextField B_nom;
    public JFXTextField B_Quan;
    public JFXTextField B_gout;
    public JFXTextField B_marque;
    public JFXComboBox B_type;
    public JFXTextField B_prix;
    public JFXTextField B_calorie;

    public JFXTextField R_nom;
    public JFXTextField R_Quan;
    public JFXComboBox R_type;
    public JFXTextField R_prix;
    public JFXTextField R_calorie;


    public JFXTextField S_nom;
    public JFXTextField S_calorie;
    public JFXTextField S_prix;
    public JFXTextField R_ing;

    void setesimeal(EsiMeal e)
    {
        this.e=e;
    }
    public void B_valider(ActionEvent actionEvent) {
        Boisson b = new Boisson(Integer.parseInt(B_Quan.getText()),Integer.parseInt(B_calorie.getText()),Integer.parseInt(B_prix.getText()),B_nom.getText(),TypeBoisson.valueOf(B_type.getValue().toString()),B_marque.getText(),B_gout.getText());
        e.listboisson.add(b);
        B_calorie.setText(null);B_gout.setText(null);B_marque.setText(null);B_prix.setText(null);B_nom.setText(null);B_type.getSelectionModel().select(-1);B_Quan.setText(null);
    }

    public void R_valider(ActionEvent actionEvent) {

        repas b = new repas(Integer.parseInt(R_Quan.getText()),Integer.parseInt(R_calorie.getText()),Integer.parseInt(R_prix.getText()),R_nom.getText(),Typerepas.valueOf(R_type.getValue().toString()),R_ing.getText());

        e.listrepas.add(b);


        R_Quan.setText(null);R_calorie.setText(null); R_ing.setText(null); R_nom.setText(null); R_prix.setText(null); R_type.getSelectionModel().select(-1);
    }

    public void S_valider(ActionEvent actionEvent) {
        Supplement s = new Supplement(Integer.parseInt(S_calorie.getText()),Integer.parseInt(S_prix.getText()),S_nom.getText());

        e.listsup.add(s);

        S_prix.setText(null); S_calorie.setText(null); S_nom.setText(null);
    }

    public void T_valider(ActionEvent actionEvent) {
        Table t= new Table(Integer.parseInt(T_nom.getText()),TypeTable.valueOf(T_type.getValue().toString()));
        e.listTables.add(t);

        T_nom.setText(null);T_type.getSelectionModel().select(-1);
    }
}
