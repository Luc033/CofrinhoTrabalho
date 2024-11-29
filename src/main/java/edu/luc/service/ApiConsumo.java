package edu.luc.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * A classe ApiConsumo é responsável por consumir uma API externa de taxas de câmbio para obter
 * as taxas de conversão das moedas Dólar (USD) e Euro (EUR) para o Real (BRL).
 *
 * A API utilizada é a "https://v6.exchangerate-api.com/v6" com uma chave de API específica.
 * As taxas de câmbio são obtidas a partir de requisições HTTP para as moedas baseadas em USD e EUR.
 *
 * Após a resposta ser recebida, as taxas de câmbio do Dólar e do Euro em relação ao Real são armazenadas
 * nos campos `CAMBIO_DOLAR` e `CAMBIO_EURO` da classe, para que possam ser utilizadas por outras classes
 * para realizar conversões monetárias.
 */
public class ApiConsumo {
    // URL base da API de taxas de câmbio
    private final String URL = "https://v6.exchangerate-api.com/v6";

    // Chave da API para autenticação
    private final String API_KEY = "/498d4b9e9ba20aa22451631d";

    // Taxas de câmbio do Dólar e do Euro em relação ao Real
    private final double CAMBIO_DOLAR;
    private final double CAMBIO_EURO;

    /**
     * Construtor que realiza a comunicação com a API para obter as taxas de câmbio.
     * A API é consumida duas vezes para obter as taxas de conversão do Dólar (USD) e do Euro (EUR)
     * para o Real (BRL). As taxas são armazenadas nos atributos da classe.
     *
     * @throws URISyntaxException Se a URI estiver mal formada.
     * @throws IOException Caso haja um erro durante a comunicação com a API.
     * @throws InterruptedException Caso a operação de requisição HTTP seja interrompida.
     */
    public ApiConsumo() throws URISyntaxException, IOException, InterruptedException{
        // Criação de um cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Requisição para obter a taxa de câmbio do Dólar (USD) para o Real (BRL)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL + API_KEY + "/latest/USD"))
                .GET()
                .build();

        // Envio da requisição e obtenção da resposta
        String responseBody = client.send(request, HttpResponse.BodyHandlers.ofString())
                .body();

        // Conversão do corpo da resposta JSON para um objeto Java
        CurrencyApiResponse currencyResponse = new Gson().fromJson(responseBody, CurrencyApiResponse.class);

        // Armazenamento da taxa de câmbio do Dólar para o Real
        CAMBIO_DOLAR = currencyResponse.getConversion_rates().get("BRL");

        // Requisição para obter a taxa de câmbio do Euro (EUR) para o Real (BRL)
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI(URL + API_KEY + "/latest/EUR"))
                .GET()
                .build();

        // Envio da requisição e obtenção da resposta
        String responseBody2 = client.send(request2, HttpResponse.BodyHandlers.ofString())
                .body();

        // Conversão do corpo da resposta JSON para um objeto Java
        CurrencyApiResponse currencyResponse2 = new Gson().fromJson(responseBody2, CurrencyApiResponse.class);

        // Armazenamento da taxa de câmbio do Euro para o Real
        CAMBIO_EURO = currencyResponse2.getConversion_rates().get("BRL");
    }

    /**
     * Método para obter a taxa de câmbio do Dólar (USD) para o Real (BRL).
     *
     * @return A taxa de câmbio do Dólar para o Real.
     */
    public double getCAMBIO_DOLAR() {
        return CAMBIO_DOLAR;
    }

    /**
     * Método para obter a taxa de câmbio do Euro (EUR) para o Real (BRL).
     *
     * @return A taxa de câmbio do Euro para o Real.
     */
    public double getCAMBIO_EURO() {
        return CAMBIO_EURO;
    }
}
