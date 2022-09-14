package Lesson7;

import java.io.IOException;
import java.util.List;


public class Homework7 {
    public static void main(String[] args) throws IOException {
        AccuWeather aw = new AccuWeather();
        aw.getWeatherByCity("Лондон").forEach(x -> System.out.println(x.toString()));
        aw.getWeatherByCity("Париж").forEach(x -> System.out.println(x.toString()));
    }
}
