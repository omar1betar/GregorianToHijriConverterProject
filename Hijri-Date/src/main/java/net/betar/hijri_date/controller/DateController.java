package net.betar.hijri_date.controller;

import lombok.AllArgsConstructor;
import net.betar.hijri_date.data.DateWrapper;
import net.betar.hijri_date.service.DateConversionService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/hijri")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class DateController {

    private final DateConversionService dateConversionService;

    @PostMapping("/convert")
    public String convertDate(@RequestBody DateWrapper dateWrapper) {
        LocalDate date = dateWrapper.getDate();
        return dateConversionService.convertToHijri(date);
    }
}
