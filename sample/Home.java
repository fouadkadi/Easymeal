package sample;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

public class Home implements Initializable {


   EsiMeal e;
    public JFXTreeTableView clientview;
    public JFXTreeTableView commandeview;
    public JFXTreeTableView commandeviewdone;
    public JFXTreeTableView rapasview;
    public JFXTreeTableView boissoinview;
    public JFXTreeTableView supview;
    @FXML
    public JFXTreeTableView clientnonview;

    ArrayList<Commande> commf= new ArrayList<>();
    ArrayList<Commande> commandes = new ArrayList<>();


    public Home(EsiMeal e){this.e=e;}

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        for (clientfidel co:e.Listeclientfidel
             ) {
            System.out.println(co.nom+co.num);

        }



        // ------------------------------------------------ Liste des Clients ----------------------------------------------///

        JFXTreeTableColumn<Cli, String> Name = new JFXTreeTableColumn<>("Nom");
        Name.setPrefWidth(150);
        Name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Cli, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Cli, String> param) {
                return param.getValue().getValue().Nom;
            }
        });

        JFXTreeTableColumn<Cli, String> prenom = new JFXTreeTableColumn<>("Prenom");
        prenom.setPrefWidth(150);
        prenom.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Cli, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Cli, String> param) {
                return param.getValue().getValue().Prenom;
            }
        });

        JFXTreeTableColumn<Cli, String> num = new JFXTreeTableColumn<>("Num");
        num.setPrefWidth(150);
        num.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Cli, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Cli, String> param) {
                return param.getValue().getValue().Num;
            }
        });



        ObservableList<Cli> clients = FXCollections.observableArrayList(makelist(e.Listeclientfidel));
        final TreeItem<Cli> root = new RecursiveTreeItem<Cli>(clients, RecursiveTreeObject::getChildren);
        clientview.getColumns().setAll(Name, prenom, num);
        clientview.setRoot(root);
        clientview.setShowRoot(false);

        if(e.listclient.size()!=0){

        ObservableList<Cli> clientnon = FXCollections.observableArrayList(makelist2(e.listclient));
        final TreeItem<Cli> non = new RecursiveTreeItem<Cli>(clientnon, RecursiveTreeObject::getChildren);
        clientnonview.getColumns().setAll(Name, prenom, num);
        clientnonview.setRoot(non);
        clientnonview.setShowRoot(false);}




        //---------------------------------------------------- Liste des commande ----------------------------------------//

        JFXTreeTableColumn<Comm, String> client = new JFXTreeTableColumn<>("Client");
        client.setPrefWidth(150);
        client.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Comm, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Comm, String> param) {
                return param.getValue().getValue().Client;
            }
        });

        JFXTreeTableColumn<Comm, String> type = new JFXTreeTableColumn<>("Type");
        type.setPrefWidth(150);
        type.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Comm, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Comm, String> param) {
                return param.getValue().getValue().Type;
            }
        });

        JFXTreeTableColumn<Comm, String> date = new JFXTreeTableColumn<>("Date");
        date.setPrefWidth(150);
        date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Comm, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Comm, String> param) {
                return param.getValue().getValue().Date;
            }
        });

        JFXTreeTableColumn<Comm, String> panier = new JFXTreeTableColumn<>("Panier");
        panier.setPrefWidth(150);
        panier.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Comm, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Comm, String> param) {
                return param.getValue().getValue().Pannier;
            }
        });

        JFXTreeTableColumn<Comm, String> Nombrepr = new JFXTreeTableColumn<>("Nbr_personne");
        Nombrepr.setPrefWidth(150);
        Nombrepr.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Comm, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Comm, String> param) {
                return param.getValue().getValue().Nombrepr;
            }
        });


        commandeview.getColumns().setAll(client, type, date,panier,Nombrepr);


        ObservableList<Comm> commandeatt = FXCollections.observableArrayList(makelistcom(e.listcmdenAttente));
        final TreeItem<Comm> cmroot = new RecursiveTreeItem<Comm>(commandeatt, RecursiveTreeObject::getChildren);




        commandeview.setRoot(cmroot);
        commandeview.setShowRoot(false);
        if(e.listcmdEffect.size()!=0){
        ObservableList<Comm> commandefaite = FXCollections.observableArrayList(makelistcom(e.listcmdEffect));
        final TreeItem<Comm> cmfroot = new RecursiveTreeItem<Comm>(commandefaite, RecursiveTreeObject::getChildren);
        commandeviewdone.getColumns().setAll(client, type, date,panier,Nombrepr);
        commandeviewdone.setRoot(cmfroot);
        commandeviewdone.setShowRoot(false);
        }

        //---------------------------------------- Liste des repas ---------------------------------------------------//




        JFXTreeTableColumn<rep, String> repas = new JFXTreeTableColumn<>("Repas");
        repas.setPrefWidth(150);
       repas.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<rep, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<rep, String> param) {
                return param.getValue().getValue().repas;
            }
        });

        JFXTreeTableColumn<rep, String> typerep = new JFXTreeTableColumn<>("Type");
        typerep.setPrefWidth(150);
        typerep.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<rep, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<rep, String> param) {
                return param.getValue().getValue().type;
            }
        });

        JFXTreeTableColumn<rep, String> ing = new JFXTreeTableColumn<>("Ingrédients");
        ing.setPrefWidth(150);
        ing.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<rep, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<rep, String> param) {
                return param.getValue().getValue().ingredient;
            }
        });


        JFXTreeTableColumn<rep, String> sule= new JFXTreeTableColumn<>("Sup");
        sule.setPrefWidth(150);
        sule.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<rep, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<rep, String> param) {
                return param.getValue().getValue().sup;
            }
        });

        JFXTreeTableColumn<rep, String> q = new JFXTreeTableColumn<>("Quantité");
        q.setPrefWidth(150);
        q.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<rep, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<rep, String> param) {
                return param.getValue().getValue().quantité;
            }
        });




        JFXTreeTableColumn<rep, String> prix = new JFXTreeTableColumn<>("Prix");
        prix.setPrefWidth(150);
        prix.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<rep, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<rep, String> param) {
                return param.getValue().getValue().prix;
            }
        });

        JFXTreeTableColumn<rep, String> calo = new JFXTreeTableColumn<>("Calories");
        calo.setPrefWidth(150);
        calo.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<rep, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<rep, String> param) {
                return param.getValue().getValue().calorie;
            }
        });



        ObservableList<rep> rep = FXCollections.observableArrayList(makelistrp(e.listrepas));
        final TreeItem<rep> root2 = new RecursiveTreeItem<rep>(rep, RecursiveTreeObject::getChildren);
        rapasview.getColumns().setAll(repas,typerep,ing,sule,prix,q,calo);
        rapasview.setRoot(root2);
        rapasview.setShowRoot(false);

        //---------------------------------- Liste des boissons ---------------------------------------------------//


        JFXTreeTableColumn<boi, String> boisson = new JFXTreeTableColumn<>("Boisson");
        boisson.setPrefWidth(150);
        boisson.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<boi, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<boi, String> param) {
                return param.getValue().getValue().boisson;
            }
        });

        JFXTreeTableColumn<boi, String> typeb = new JFXTreeTableColumn<>("Type");
        typeb.setPrefWidth(150);
        typeb.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<boi, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<boi, String> param) {
                return param.getValue().getValue().type;
            }
        });


        JFXTreeTableColumn<boi, String> marque = new JFXTreeTableColumn<>("Marque");
        marque.setPrefWidth(150);
        marque.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<boi, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<boi, String> param) {
                return param.getValue().getValue().marque;
            }
        });

        JFXTreeTableColumn<boi, String> gout = new JFXTreeTableColumn<>("Gout");
        gout.setPrefWidth(150);
        gout.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<boi, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<boi, String> param) {
                return param.getValue().getValue().gout;
            }
        });


        JFXTreeTableColumn<boi, String> prixb = new JFXTreeTableColumn<>("Prix");
        prixb.setPrefWidth(150);
        prixb.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<boi, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<boi, String> param) {
                return param.getValue().getValue().prix;
            }
        });

        JFXTreeTableColumn<boi, String> quantb = new JFXTreeTableColumn<>("Quantité");
        quantb.setPrefWidth(150);
        quantb.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<boi, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<boi, String> param) {
                return param.getValue().getValue().quantité;
            }
        });


        ObservableList<boi> boiObservableList = FXCollections.observableArrayList(makelistboi(e.listboisson));
        final TreeItem<boi> root3 = new RecursiveTreeItem<boi>(boiObservableList, RecursiveTreeObject::getChildren);
        boissoinview.getColumns().setAll(boisson,typeb,marque,gout,prixb,quantb);
        boissoinview.setRoot(root3);
        boissoinview.setShowRoot(false);


        //---------------------------------------------------------------- Liste des supplement ------------------------------------------------//


        JFXTreeTableColumn<sup, String> supl = new JFXTreeTableColumn<>("Supplement");
        supl.setPrefWidth(150);
        supl.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<sup, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<sup, String> param) {
                return param.getValue().getValue().supli;
            }
        });

        JFXTreeTableColumn<sup, String> calos= new JFXTreeTableColumn<>("Calories");
        calos.setPrefWidth(150);
        calos.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<sup, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<sup, String> param) {
                return param.getValue().getValue().calorie;
            }
        });

        JFXTreeTableColumn<sup, String> prixs= new JFXTreeTableColumn<>("Prix");
        prixs.setPrefWidth(150);
        prixs.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<sup, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<sup, String> param) {
                return param.getValue().getValue().prix;
            }
        });

        ObservableList<sup> supObservableList = FXCollections.observableArrayList(makelistsup(e.listsup));
        System.out.println(supObservableList.size());
        final TreeItem<sup> supviewroot = new RecursiveTreeItem<sup>(supObservableList, RecursiveTreeObject::getChildren);
        supview.getColumns().setAll(supl,calos,prixs);
        supview.setRoot(supviewroot);
        supview.setShowRoot(false);

    }





    ArrayList<Cli> makelist(ArrayList<clientfidel> l)
    {
        ArrayList<Cli> list = new ArrayList<>();

        for (clientfidel e:l
             ) {

            Cli s = new Cli(e.nom,e.prenom,e.num);
            list.add(s);

        }

        return list;
    }

    ArrayList<Cli> makelist2(ArrayList<client> l)
    {
        ArrayList<Cli> list = new ArrayList<>();

        for (client e:l
                ) {

            Cli s = new Cli(e.nom,e.prenom,e.num);
            list.add(s);

        }

        return list;
    }



    ArrayList<Comm> makelistcom(ArrayList<Commande> l)
    {
        ArrayList<Comm> list = new ArrayList<>();

        for (Commande e:l
                ) {

            Comm s = new Comm(e);
            list.add(s);

        }

        return list;
    }




    ArrayList<rep> makelistrp(ArrayList<repas> l)
    {
        ArrayList<rep> list = new ArrayList<>();

        for (repas e:l
                ) {

            rep s = new rep(e);
            list.add(s);

        }

        return list;
    }



    ArrayList<boi> makelistboi(ArrayList<Boisson> l)
    {
        ArrayList<boi> list = new ArrayList<>();

        for (Boisson e:l
                ) {

            boi s = new boi(e);
            list.add(s);

        }

        return list;
    }



    ArrayList<sup> makelistsup(ArrayList<Supplement> l)
    {
        ArrayList<sup> list = new ArrayList<>();

        for (Supplement e:l
                ) {

            sup s = new sup(e);
            list.add(s);

        }

        return list;
    }





    class Cli extends RecursiveTreeObject<Cli> {

        StringProperty Nom;
        StringProperty Prenom;
        StringProperty Num;

        public Cli(String Nom, String Prenom, String Num) {
            this.Nom = new SimpleStringProperty(Nom);
            this.Prenom = new SimpleStringProperty(Prenom);
            this.Num = new SimpleStringProperty(Num);
        }

    }

    class Comm extends RecursiveTreeObject<Comm> {

        StringProperty Client;
        StringProperty Type;
        StringProperty Date;
        StringProperty Pannier;
        StringProperty Nombrepr;

        public Comm(Commande c) {
            this.Client = new SimpleStringProperty(c.cli.nom);



            this.Type = new SimpleStringProperty(type(c));
            this.Date = new SimpleStringProperty(c.heure.toString());
            this.Pannier= new SimpleStringProperty(pan(c));
            this.Nombrepr= new SimpleStringProperty(String.valueOf(c.nb_persone));
        }

        private String type(Commande c)
        {
            String a="";

            if(c.getClass().getSimpleName().equals("commande_livré")){ a="Domicile :"+((commande_livré)c).Adr+"/"+ ((commande_livré)c).nbkilo +"Km";}
            if(c.getClass().getSimpleName().equals("commande_surplace")){  a="Sur place"+"/"+((commande_surplace)c).tt;}


            return a;


        }
        private  String pan(Commande k)
        {   String r="";
            for (Article a:k.menu
                 ) {

                r+=a.nom+"+";
            }
            return r;
        }


    }



    class rep extends RecursiveTreeObject<rep> {

        StringProperty repas;
        StringProperty type;
        StringProperty ingredient;
        StringProperty sup;
        StringProperty calorie;
        StringProperty quantité;
        StringProperty prix;

        public rep(repas r) {
            this.repas = new SimpleStringProperty(r.nom);
            this.type=new SimpleStringProperty(r.type.toString());
            this.ingredient=new SimpleStringProperty(r.ingredient);
            this.sup=new SimpleStringProperty(r.sup.toString());
            this.calorie=new SimpleStringProperty(String.valueOf(r.nbr_cal));
            this.quantité=new SimpleStringProperty(String.valueOf(r.dispo));
            this.prix=new SimpleStringProperty(String.valueOf(r.prix));
        }

    }



    class boi extends RecursiveTreeObject<boi> {

        StringProperty boisson;
        StringProperty type;
        StringProperty marque;
        StringProperty gout;
        StringProperty quantité;
        StringProperty prix;

        public boi(Boisson r) {
            this.boisson = new SimpleStringProperty(r.nom);
            this.type=new SimpleStringProperty(r.type.toString());
            this.marque=new SimpleStringProperty(r.marque);
            this.gout=new SimpleStringProperty(r.gout);

            this.quantité=new SimpleStringProperty(String.valueOf(r.dispo));
            this.prix=new SimpleStringProperty(String.valueOf(r.prix));
        }

    }


    class sup extends RecursiveTreeObject<sup> {

        StringProperty supli;
        StringProperty calorie;
        StringProperty prix;

        public sup(Supplement r) {
            this.supli= new SimpleStringProperty(r.nom);
            this.calorie=new SimpleStringProperty(String.valueOf(r.nbr_cal));
            this.prix=new SimpleStringProperty(String.valueOf(r.prix));

        }

    }
}
