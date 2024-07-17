package com.brugalibre.timeslotplanner.domain.model.vacation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Builder;

import java.time.LocalDate;

/**
 * A {@link BusinessVacation} defines a vacation/holiday during which the business is closed. It's defined by a beginn and an end date
 *
 * @param beginn the beginn of the holiday
 * @param end    the end of the holiday
 */
@Builder
public record BusinessVacation(
        @JsonDeserialize(using = LocalDateDeserializer.class) @JsonFormat(pattern = "dd.MM.yyyy") LocalDate beginn,
        @JsonDeserialize(using = LocalDateDeserializer.class) @JsonFormat(pattern = "dd.MM.yyyy") LocalDate end) {
}
