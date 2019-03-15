package pl.sda.javafx.openWeather;

import pl.sda.javafx.serivce.WeatherService;
import pl.sda.javafx.openWeather.Current;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String city="empty";

        while(!city.equals ("exit")) {
            Scanner scanner = new Scanner (System.in);
            System.out.println ("Podaj nazwe miasta dla którego chcesz wyświetlić informacjie, jeśli chcesz wyjść wpisz \"exit\"");
            city = scanner.nextLine ();
            if(!city.equals ("exit")) {
                readWeather (city);
            }
        }

    }
    public static void readWeather(String city) throws IOException {
        WeatherService weatherService =new WeatherService ("http://api.apixu.com/v1/current.json","1b301cfd93fe4ee0bd9123325191003");
        System.out.println (weatherService.getCityWeather (city).getCurrent ().getTemp_c ());
    }
}
