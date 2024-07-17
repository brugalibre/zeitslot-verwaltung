package com.brugalibre.timeslotplanner.domain.model.businessclosed;

import java.time.LocalDate;

public record BusinessClosedDay(LocalDate date, BusinessClosedReason businessClosedReason) {
}
