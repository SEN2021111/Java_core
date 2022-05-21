package Lesson6;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;

public class Homework6 {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key="
                + "dict.1.1.20220510T151857Z.b07ccb036d309f3d.aa46f8fcd6e56dd16a7ed9085f0a64c7e84d5c0c"
                + "&lang=en-ru&text=time\n";

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        System.out.println(body);
    }
}
