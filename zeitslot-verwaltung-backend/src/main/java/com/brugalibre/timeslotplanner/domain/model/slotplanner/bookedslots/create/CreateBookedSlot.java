package com.brugalibre.timeslotplanner.domain.model.slotplanner.bookedslots.create;

import com.brugalibre.timeslotplanner.domain.model.slotplanner.TimeSlot;

import java.time.LocalDate;

public record CreateBookedSlot(String userId, LocalDate date, TimeSlot timeSlot) {
}
