package com.brugalibre.timeslotplanner.domain.model.slotplanner;

import lombok.Builder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Builder(toBuilder = true)
public record PlannerDay(LocalDate date, List<TimeSlot> timeSlots, Availability availability) {
   public PlannerDay(LocalDate date, List<TimeSlot> timeSlots) {
      this(date, timeSlots, new Availability(true, null));
   }

   public DayOfWeek getDayOfWeek() {
      return date.getDayOfWeek();
   }
}
