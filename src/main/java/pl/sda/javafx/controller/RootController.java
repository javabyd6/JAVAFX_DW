package pl.sda.javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.sda.javafx.serivce.WeatherService;


import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private Button search;
    @FXML
    private TextField city;
    @FXML
    private Label Text1;
    @FXML
    private Label TeperatureIn;


    public void initialize(URL location, ResourceBundle resources) {
      city .setText("Wpisz miasto");

    }
    public void setCity() throws IOException {

        WeatherService weatherService =new WeatherService ("http://api.apixu.com/v1/current.json","1b301cfd93fe4ee0bd9123325191003");
       TeperatureIn.setText(String.valueOf (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getTemp_c ()));

}
}
