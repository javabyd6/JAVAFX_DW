package pl.sda.javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private Button search;
    @FXML
    private TextFiled city;
    @FXML
    private Label TeperatureIn;


    public void initialize(URL location, ResourceBundle resources) {
      city .setText("Test123");
      TeperatureIn.setText("");
    }
    public void setCity(){
        System.out.println ("Klik");
    }
}
