package com.email.replyai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailService {

        private final WebClient webClient;
        private final String geminiApiUrl;
        private final String geminiApiKey;

        public EmailService(
                WebClient.Builder webClientBuilder,
                @Value("${gemini.api.url}") String geminiApiUrl,
                @Value("${gemini.api.key}") String geminiApiKey) {
            this.webClient = webClientBuilder.build();
            this.geminiApiUrl = geminiApiUrl;
            this.geminiApiKey = geminiApiKey;
        }

        public String generateEmailReply(EmailResponse emailResponse) {
            String prompt = buildPrompt(emailResponse);

            Map<String, Object> requestBody = Map.of(
                    "contents", new Object[]{
                            Map.of("parts", new Object[]{
                                    Map.of("text", prompt)
                            })
                    }
            );

            String response = webClient.post()
                    .uri(geminiApiUrl + "?key=" + geminiApiKey) // safer than simple concatenation
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return extractResponseContent(response);
        }

    private String extractResponseContent(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            return "Error processing request: " + e.getMessage();
        }
    }

    public String buildPrompt(EmailResponse emailResponse){
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following email content. Please don't generate a subject line ");
        if (emailResponse.getTone() != null && !emailResponse.getTone().isEmpty()) {
            prompt.append("Use a ").append(emailResponse.getTone()).append(" tone.");
        }
        prompt.append("\nOriginal email: \n").append(emailResponse.getEmailContent());
        return prompt.toString();
    }

}
