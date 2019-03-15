package pl.sda.javafx.serivce;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.javafx.openWeather.Weather;

import java.io.IOException;
import java.net.URL;

public class WeatherService {
    private String finalURL;



    public  WeatherService(String url, String apiKey) {
        this.finalURL=(url+"?key="+apiKey+"&q=");
    }
    public Weather getCityWeather(String city) throws IOException {
        ObjectMapper mapper = new ObjectMapper ();

        Weather weather = mapper.readValue(new URL (finalURL+city),Weather.class);

        return weather;
        /*System.out.println ("W mieście "+weather.getLocation ().getName ()+" obecnie jest temperatura "+weather.getCurrent ().getTemp_c ()+"°C");*/
    }


}
