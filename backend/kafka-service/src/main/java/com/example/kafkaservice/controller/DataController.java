package com.example.kafkaservice.controller;

import com.example.kafkaservice.producer.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class DataController {

    private final KafkaProducerService producerService;

    public DataController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/fetch")
    public String fetchDataAndSendToKafka() {
        // Set up HTTP client and request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-trending-tickers?region=US"))
                .header("x-rapidapi-key", "942468a801msh0094a3b2ae1c198p1fd592jsnd6e02b7a8c63")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .GET()
                .build();

        try {
            // Send request and get response
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            // Log and send data to Kafka
            String responseBody = response.body();
            System.out.println("Fetched data: " + responseBody);
            producerService.publishMessage("financial-trends", responseBody);

            return "Data fetched and sent to Kafka successfully.";

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Failed to fetch data from RapidAPI.";
        }
    }
}
