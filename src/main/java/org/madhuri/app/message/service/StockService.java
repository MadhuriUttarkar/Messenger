package org.madhuri.app.message.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.madhuri.app.message.constant.Constants;
import org.madhuri.app.message.model.Stock;
import org.madhuri.app.message.model.StockResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StockService {
	
	private static final String API_BASE_URL = "https://finnhub.io/api/v1/quote";
	private static final String API_SEARCH_URL = "https://finnhub.io/api/v1/search";

	public Stock getStockData(String symbol) throws IOException, InterruptedException {
        String apiUrl = API_BASE_URL + "?symbol=" + symbol + "&token=" + Constants.API_TOKEN;

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

	public StockResponse searchSymbols(String query) throws IOException, InterruptedException {
	    String apiUrl = API_SEARCH_URL + "?q=" + query + "&token=" + Constants.API_TOKEN;

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
	        StockResponse stockResponse = mapper.readValue(responseBody, StockResponse.class);
	        return stockResponse;
	    } else {
	        throw new IOException("HTTP request failed with status code " + response.statusCode());
	    }
	}
}


