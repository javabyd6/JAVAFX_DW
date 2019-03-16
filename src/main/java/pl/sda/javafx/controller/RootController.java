package pl.sda.javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    WeatherService weatherService = new WeatherService ("http://api.apixu.com/v1/current.json", "1b301cfd93fe4ee0bd9123325191003");
    city.setText (ChangePolishChars (city.getText ()));
    TemperatureCIn.setText ((weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getTemp_c ()) + " °C");
    CityIn.setText (weatherService.getCityWeather (city.getText ()).getLocation ().getName ());
    CountryIn.setText (weatherService.getCityWeather (city.getText ()).getLocation ().getCountry ());
    LocalTime.setText (weatherService.getCityWeather (city.getText ()).getLocation ().getLocaltime ());
    UpdateTime.setText (weatherService.getCityWeather (city.getText ()).getCurrent ().getLast_updated ());
    Description.setText (weatherService.getCityWeather (city.getText ()).getCurrent ().getCondition ().getText ());
    FeelTemperatureCIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getFeelslike_c () + " °C");
    FeelTemperatureFIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getFeelslike_f () + " °F");
    TemperatureFIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getTemp_f () + " °F");
    WindKphIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getWind_kph () + " kph");
    WindMphIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getWind_mph () + " mph");
    PressureIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getPressure_mb () + " hPa");
    HumdityIn.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getHumidity () + "%");
    Cloudy.setText (weatherService.getCityWeather (String.valueOf (city.getText ())).getCurrent ().getCloud () + "%");
    WeatherImage.setImage (new Image ("http:" + weatherService.getCityWeather (city.getText ()).getCurrent ().getCondition ().getIcon ()));
}



    public String ChangePolishChars(String city){

        for (int i = 0; i < city.length (); i++)
            switch (city.charAt (i)) {

                case 'ą':
                    city = city.replace ('ą', 'a');
                    break;
                case 'ć':
                    city = city.replace ('ć', 'c');
                    break;
                case 'ę':
                    city = city.replace ('ę', 'e');
                    break;
                case 'ł':
                    city = city.replace ('ł', 'l');
                    break;
                case 'ń':
                    city = city.replace ('ń', 'n');
                    break;
                case 'ó':
                    city = city.replace ('ó', 'o');
                    break;
                case 'ś':
                    city = city.replace ('ś', 's');
                    break;
                case 'ź':
                    city = city.replace ('ź', 'z');
                    break;
                case 'ż':
                    city = city.replace ('ż', 'z');
                    break;
                case 'Ą':
                    city = city.replace ('Ą', 'A');
                    break;
                case 'Ć':
                    city = city.replace ('Ć', 'c');
                    break;
                case 'Ę':
                    city = city.replace ('Ę', 'E');
                    break;
                case 'Ł':
                    city = city.replace ('Ł', 'L');
                    break;
                case 'Ń':
                    city = city.replace ('Ń', 'N');
                    break;
                case 'Ó':
                    city = city.replace ('Ó', 'O');
                    break;
                case 'Ś':
                    city = city.replace ('Ś', 'S');
                    break;
                case 'Ź':
                    city = city.replace ('Ź', 'Z');
                    break;
                case 'Ż':
                    city = city.replace ('Ż', 'Z');
                    break;

            }
       return city;
    }
}
