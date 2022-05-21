package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private Date date;
    private Temperature temperature;
    private DayPart day;
    private DayPart night;

    @JsonSetter("Day")
    private void setDay(DayPart day) {
        this.day = day;
    }

    @JsonSetter("Night")
    private void setNight(DayPart night) {
        this.night = night;
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

    public Date getDate() {
        return date;
    }

    public long getMinTemperature() {
        return temperature.getMinimum();
    }

    public long getMaxTemperature() {
        return temperature.getMaximum();
    }

    public String getDayPhrase() {
        return day.getPhrase();
    }

    public String getNightPhrase() {
        return day.getPhrase();
    }
}