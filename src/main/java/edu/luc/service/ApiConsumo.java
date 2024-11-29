package edu.luc.service;

import edu.luc.model.CurrencyApiResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;

public class ApiConsumo {
    private final String URL = "https://v6.exchangerate-api.com/v6";
    private final String API_KEY = "/498d4b9e9ba20aa22451631d";
    private final double CAMBIO_DOLAR;
    private final double CAMBIO_EURO;

    public ApiConsumo() throws URISyntaxException, IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL + API_KEY + "/latest/USD"))
                .GET()
                .build();
        String responseBody = client.send(request, HttpResponse.BodyHandlers.ofString())
                .body();

        CurrencyApiResponse currencyResponse = new Gson().fromJson(responseBody, CurrencyApiResponse.class);
        CAMBIO_DOLAR = currencyResponse.getConversion_rates().get("BRL");

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI(URL + API_KEY + "/latest/EUR"))
                .GET()
                .build();
        String responseBody2 = client.send(request2, HttpResponse.BodyHandlers.ofString())
                .body();

        CurrencyApiResponse currencyResponse2 = new Gson().fromJson(responseBody2, CurrencyApiResponse.class);
        CAMBIO_EURO = currencyResponse2.getConversion_rates().get("BRL");
    }

    public double getCAMBIO_DOLAR() {
        return CAMBIO_DOLAR;
    }

    public double getCAMBIO_EURO() {
        return CAMBIO_EURO;
    }
}
