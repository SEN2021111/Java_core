package Lesson7;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Weather {
    public String cityName;
    public Date date;
    public String dayPhrase;
    public String nightPhrase;
    public long minTemperature;
    public long maxTemperature;

    public Weather(
            String cityName,
            Date date,
            String dayPhrase,
            String nightPhrase,
            long minTemperature,
            long maxTemperature) {
        this.cityName = cityName;
        this.date = date;
        this.dayPhrase = dayPhrase;
        this.nightPhrase = nightPhrase;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return String.format("В г.%s на дату %s, днем - %s, ночью - %s, температура от %s до %s градусов цельсия"
                , this.cityName
                , new SimpleDateFormat("dd.mm.yyyy").format(this.date)
                , this.dayPhrase
                , this.nightPhrase
                , this.minTemperature
                , this.maxTemperature
        );
    }
}
