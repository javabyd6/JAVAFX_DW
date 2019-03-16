package pl.sda.javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.sda.javafx.serivce.WeatherService;


import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private Button search;
    @FXML
    private TextField city;
   /* @FXML
    private Label Text1;*/
    @FXML
    private Label TemperatureCIn;
    @FXML
    private Label CityIn;
    @FXML
    private Label CountryIn;
    @FXML
    private Label LocalTime;
    @FXML
    private Label UpdateTime;
    @FXML
    private Label Description;
    @FXML
    private Label FeelTemperatureCIn;
    @FXML
    private Label FeelTemperatureFIn;
    @FXML
    private Label TemperatureFIn;
    @FXML
    private Label WindKphIn;
    @FXML
    private Label WindMphIn;
    @FXML
    private Label PressureIn;
    @FXML
    private Label HumdityIn;
    @FXML
    private Label Cloudy;
    @FXML
    private ImageView WeatherImage;






    public void initialize(URL location, ResourceBundle resources) {
      city .setText("Wpisz miasto");

    }
    public void setCity() throws IOException {

        WeatherService weatherService =new WeatherService ("http://api.apixu.com/v1/current.json","1b301cfd93fe4ee0bd9123325191003");
       TemperatureCIn.setText((weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getTemp_c ())+" °C");
       CityIn.setText (weatherService.getCityWeather (city.getText ()).getLocation ().getName ());
       CountryIn.setText (weatherService.getCityWeather (city.getText ()).getLocation ().getCountry ());
       LocalTime.setText (weatherService.getCityWeather (city.getText ()).getLocation ().getLocaltime ());
       UpdateTime.setText (weatherService.getCityWeather (city.getText ()).getCurrent ().getLast_updated ());
       Description.setText (weatherService.getCityWeather (city.getText ()).getCurrent ().getCondition ().getText ());
       FeelTemperatureCIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getFeelslike_c ()+ " °C");
       FeelTemperatureFIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getFeelslike_f ()+ " °F");
       TemperatureFIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getTemp_f ()+ " °F");
       WindKphIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getWind_kph ()+ " kph");
       WindMphIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getWind_mph ()+ " mph");
       PressureIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getPressure_mb ()+ "hPa");
       HumdityIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getHumidity ()+ "%");
       Cloudy.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getCloud ()+ "%");
       //WeatherImage.getImageURL (new URL (weatherService.getCityWeather (city.getText ()).getCurrent ().getCondition ().getIcon ()));

    }
}
