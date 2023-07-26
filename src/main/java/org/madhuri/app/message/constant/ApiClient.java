package org.madhuri.app.message.constant;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.madhuri.app.message.model.Stock;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiClient {

	static final String API_BASE_URL = "https://finnhub.io/api/v1/quote";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the stock symbol: ");
        String symbol = scanner.nextLine();
        scanner.close();

        String apiUrl = API_BASE_URL + "?symbol=" + symbol + "&token=" + Constants.API_TOKEN;

        try {
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
                System.out.println("JSON Response:\n" + responseBody); // Print JSON response for debugging purposes

                // parse JSON
                ObjectMapper mapper = new ObjectMapper();
                Stock stock = mapper.readValue(responseBody, Stock.class);

                // Process the stock data
                System.out.println(stock);
            } else {
                System.err.println("Error: HTTP request failed with status code " + response.statusCode());
            }
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("InterruptedException occurred: " + e.getMessage());
        }
    }
}

