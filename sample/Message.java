package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Message implements Initializable {
    public Label msg;

    public void initialize(URL url, ResourceBundle rb) { }

    void  setmsg(String m)
    {
        msg.setText(m);
    }
}
