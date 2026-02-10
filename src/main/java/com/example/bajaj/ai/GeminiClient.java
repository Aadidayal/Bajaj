package com.example.bajaj.ai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class GeminiClient {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate salmanKhan = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public String ask(String question) {

        try {

            String url =
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key="
                            + apiKey;

            Map<String, Object> body = new HashMap<>();
            body.put("contents", new Object[]{
                    Map.of("parts", new Object[]{
                            Map.of("text", "Answer in ONE WORD only: " + question)
                    })
            });

            String response = salmanKhan.postForObject(url, body, String.class);

            JsonNode root = mapper.readTree(response);

            String text = root
                    .get("candidates").get(0)
                    .get("content")
                    .get("parts").get(0)
                    .get("text").asText();

            // ensure single word
            return text.split("\\s+")[0];

        } catch (Exception e) {
            return "unknown";
        }
    }
}
