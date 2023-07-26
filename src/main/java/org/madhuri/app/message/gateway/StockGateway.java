package org.madhuri.app.message.gateway;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.madhuri.app.message.client.ApiToken;
import org.madhuri.app.message.model.Stock;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StockGateway {

	private static final String API_BASE_URL = "https://finnhub.io/api/v1/quote";

    public Stock getStockData(String symbol) throws IOException, InterruptedException {
        String apiUrl = API_BASE_URL + "?symbol=" + symbol + "&token=" + ApiToken.API_TOKEN;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(apiUrl))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Check if the response status code is 200 (OK)
        if (response.statusCode() == 200) {
            String responseBody = response.body();
            
            // parse JSON
            ObjectMapper mapper = new ObjectMapper();
            Stock stock = mapper.readValue(responseBody, Stock.class);
            return stock;
        } else {
            throw new IOException("HTTP request failed with status code " + response.statusCode());
        }
    }

}
