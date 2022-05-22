package Lesson7;

import java.io.IOException;
import java.util.List;


public class Homework7 {
    public static void main(String[] args) throws IOException {
        AccuWeather aw = new AccuWeather();
        List<Weather> city1 = aw.getWeatherByCity("Лондон");
        List<Weather> city2 = aw.getWeatherByCity("Париж");

        //city1.forEach(x -> System.out.println(x.toString()));
        //city2.forEach(x -> System.out.println(x.toString()));

        AccuWeatherRepository rep = new AccuWeatherRepository();
        city1.forEach(rep::insert);
        System.out.println("--Записи из БД с фильтром--");
        rep.select("Лондон").forEach(x -> System.out.println(x.toString()));
        rep.select("Париж").forEach(x -> System.out.println(x.toString()));

        rep.insertBatch(city2);
        System.out.println("--Все записи из БД--");
        rep.selectAll().forEach(x -> System.out.println(x.toString()));
    }
}
