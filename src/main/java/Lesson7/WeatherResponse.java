package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD'T'hh:mm:ssZ")
    private Date date;
    private Temperature temperature;
    private DayPart day;

    private DayPart getDay() {
        return day;
    }

    @JsonSetter("Day")
    private void setDay(DayPart day) {
        this.day = day;
    }

    private DayPart getNight() {
        return night;
    }

    @JsonSetter("Night")
    private void setNight(DayPart night) {
        this.night = night;
    }

    private DayPart night;

    private Temperature getTemperature() {
        return temperature;
    }

    @JsonSetter("Temperature")
    private void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @JsonSetter("Date")
    private void setDate(String date) throws ParseException {
        String dateStr = date.substring(0, 10);
        this.date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
    }

    private Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return String.format("на дату %s, днем - %s, ночью - %s, температура от %s до %s градусов цельсия"
                , new SimpleDateFormat("dd.mm.yyyy").format(getDate())
                ,getDay().getPhrase()
                ,getNight().getPhrase()
                ,getTemperature().getMinimum()
                ,getTemperature().getMaximum()
        );
    }
}