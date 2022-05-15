package Lesson7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class AccuWeather {

    private OkHttpClient client = new OkHttpClient();
    public String cityName;
    private String apikey = "4XJ4pAEIm4Kays3Fcz7GweCmKhV59fQA";
    private String language = "ru-ru";

    private String getCityKey(String city) throws IOException {
        URL url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("q", city)
                .addQueryParameter("apikey", apikey)
                .addQueryParameter("language", language)
                .build().url();

        Request request = new Request.Builder()
                .url(url)
                .build();

        String responseJSON = client.newCall(request).execute().body().string();
        JSONArray jsonArray = new JSONArray(responseJSON);
        JSONObject firstCity = jsonArray.getJSONObject(0);

        this.cityName = firstCity.getString("LocalizedName");

        return firstCity.getString("Key");
    }

    public List<WeatherResponse> getWeatherByCity(String city) throws IOException {
        String cityKey = getCityKey(city);
        URL url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", apikey)
                .addQueryParameter("language", language)
                .build().url();

        Request request = new Request.Builder()
                .url(url)
                .build();

        String responseJSON = client.newCall(request).execute().body().string();

        JSONArray dailyForecasts = new JSONObject(responseJSON).getJSONArray("DailyForecasts");

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                dailyForecasts.toString(), new TypeReference<List<WeatherResponse>>() {
                });
    }
}
