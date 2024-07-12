package net.betar.date_converter.controller;

import lombok.AllArgsConstructor;
import net.betar.date_converter.data.DateWrapper;
import net.betar.date_converter.service.DateService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.sql.SQLOutput;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DateController {

    private final DateService dateService;


    @PostMapping("/send")
    public Mono<String> postDate(@RequestBody DateWrapper dateWrapper) {
        LocalDate date = dateWrapper.getDate();
        return dateService.getHijriDate(date);
    }
}
