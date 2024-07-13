package net.betar.date_converter.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.betar.date_converter.data.DateWrapper;
import net.betar.date_converter.service.DateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;
import org.springframework.validation.FieldError;
import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController

@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor

public class DateController {

    private final DateService dateService;


    @PostMapping("/send")
    public ResponseEntity<Mono<String>> postDate(@Valid @RequestBody DateWrapper dateWrapper) {

        LocalDate date = dateWrapper.getDate();
        return ResponseEntity.ok(dateService.getHijriDate(date));
    }
}
