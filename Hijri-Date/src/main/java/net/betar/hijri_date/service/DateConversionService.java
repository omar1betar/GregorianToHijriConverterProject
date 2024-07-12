package net.betar.hijri_date.service;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;

@Service
public class DateConversionService {

    public String convertToHijri(LocalDate date) {
        HijrahDate hijrahDate = HijrahDate.from(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return hijrahDate.format(formatter);
    }
}
