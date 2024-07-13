package net.betar.date_converter.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.betar.date_converter.Validation.CustomDateDeserializer;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class DateWrapper {

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
