package net.betar.date_converter.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class DateService {

    private final WebClient.Builder  webClientBuilder;

    public Mono<String> getHijriDate(LocalDate date) {
        String requestBody = "{ \"date\": \"" + date.toString() + "\" }";  // Adjust this based on your actual JSON structure
        return webClientBuilder.build()
                .post()
                .uri("http://localhost:8002//api/hijri/convert")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)  // Set content type as JSON
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class);
    }
}
