package sample;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Effectue implements Initializable {
    EsiMeal e;
    public JFXComboBox liste;

    public  Effectue(EsiMeal e){this.e=e;}

    public void initialize(URL url, ResourceBundle rb)
    {
        List<String> com = e.listcmdenAttente.stream().map(u -> u.cli.nom ).collect(Collectors.toList());
        liste.setItems(FXCollections.observableList(com));
    }
    public void Effec(ActionEvent actionEvent)
    {

        if(liste.getSelectionModel().getSelectedIndex()!=-1)
        {
            e.getListcmdEffect().add(e.listcmdenAttente.get(liste.getSelectionModel().getSelectedIndex()));
            e.listcmdenAttente.remove(e.listcmdenAttente.get(liste.getSelectionModel().getSelectedIndex()));
        }

    }
}
