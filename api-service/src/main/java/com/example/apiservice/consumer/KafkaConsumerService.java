package com.example.apiservice.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "financial-trends", groupId = "financialGroup")
    public void consume(String message) {
        // Parse the JSON message and print key information
        JSONObject json = new JSONObject(message);
        System.out.println("Received trending tickers data: " + json);

        // Example: process and store data in the database or forward it to other services
        // storeDataToDatabase(json);
    }
}
