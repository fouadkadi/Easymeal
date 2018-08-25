package sample;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Panier implements Initializable {

    EsiMeal e;
    client cli;
    Commande c;
    public JFXComboBox boisson;
    public JFXComboBox repas;
    public JFXComboBox supplement;
    public JFXCheckBox supcheckbox;
    public JFXTreeTableView Panier;
    public Label prixcalcule;
    public Label prixnet;
    public  ArrayList<Article> pan=new ArrayList<>();



    public Panier(EsiMeal e,Commande c ,client cli){ this.e=e; this.c=c;this.cli=cli; }

    public  void initialize(URL url, ResourceBundle rb)
    {
        //------------------------------------------------  panier ------------------------------------//

        JFXTreeTableColumn<panier, String> supl = new JFXTreeTableColumn<>("Type");
        supl.setPrefWidth(120);
        supl.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<panier, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<panier, String> param) {
                return param.getValue().getValue().Type;
            }
        });

        JFXTreeTableColumn<panier, String> calos= new JFXTreeTableColumn<>("Nom");
        calos.setPrefWidth(120);
        calos.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<panier, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<panier, String> param) {
                return param.getValue().getValue().Nom;
            }
        });

        JFXTreeTableColumn<panier, String> prixs= new JFXTreeTableColumn<>("Prix");
        prixs.setPrefWidth(120);
        prixs.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<panier, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<panier, String> param) {
                return param.getValue().getValue().prix;
            }
        });
        Panier.getColumns().setAll(supl,calos,prixs);



        List<String> listraps = e.getListrepas().stream().map(u -> u.nom).collect(Collectors.toList());
        List<String> listboissoin = e.getListboisson().stream().map(u -> u.nom).collect(Collectors.toList());
        List<String> listsup = e.getListsup().stream().map(u -> u.nom).collect(Collectors.toList());

        repas.setItems(FXCollections.observableList(listraps));
        boisson.setItems(FXCollections.observableList(listboissoin));
        supplement.setItems(FXCollections.observableList(listsup));




    }
    public void supchecked(ActionEvent actionEvent)
    {

        if(supcheckbox.isSelected()){ supplement.setVisible(true);}else { supplement.setVisible(false);}
    }

    public void ajouter(ActionEvent actionEvent)
    {
        if(boisson.getSelectionModel().getSelectedIndex()!=-1)
        {
            pan.add(e.getListboisson().get(boisson.getSelectionModel().getSelectedIndex()));

            c.ajout(e.getListboisson().get(boisson.getSelectionModel().getSelectedIndex()));

        }
        if(repas.getSelectionModel().getSelectedIndex()!=-1)
        {   c.ajout(e.getListrepas().get(repas.getSelectionModel().getSelectedIndex()));
            pan.add(e.getListrepas().get(repas.getSelectionModel().getSelectedIndex()));
        }
        if(supplement.getSelectionModel().getSelectedIndex()!=-1 && supcheckbox.isSelected())
        {

            c.ajout(e.getListsup().get(supplement.getSelectionModel().getSelectedIndex()));

            pan.add(e.getListsup().get(supplement.getSelectionModel().getSelectedIndex()));

        }


        supplement.getSelectionModel().select(-1);
        repas.getSelectionModel().select(-1);

        boisson.getSelectionModel().select(-1);


        ObservableList<panier> supObservableList = FXCollections.observableArrayList(makepanier(pan));
        final TreeItem<panier> supviewroot = new RecursiveTreeItem<panier>(supObservableList, RecursiveTreeObject::getChildren);

        Panier.setRoot(supviewroot);
        Panier.setShowRoot(false);
        prixcalcule.setText(String.valueOf(c.Prix()));
        prixnet.setText(String.valueOf(c.PrixFinale()));


    }



    ArrayList<panier> makepanier(ArrayList<Article> l)
    {
        ArrayList<panier> list = new ArrayList<>();

        for (Article e:l
                ) {

            panier s = new panier(e);
            list.add(s);

        }

        return list;
    }

    public void validerpan(ActionEvent actionEvent) {

        c.menu.addAll(pan);
        cli.ajout_commande(c.heure,c);
        e.getListcmdenAttente().add(c);





    }

    class panier extends RecursiveTreeObject<panier> {

        StringProperty Type;
        StringProperty Nom;
        StringProperty prix;

        public panier(Article r) {
            this.Type= new SimpleStringProperty(r.getClass().getSimpleName());
            this.Nom=new SimpleStringProperty(String.valueOf(r.nom));
            this.prix=new SimpleStringProperty(String.valueOf(r.prix));

        }

    }




}
