package com.brugalibre.timeslotplanner.domain.model.plannertemplate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.DayOfWeek;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record PlannerDayTemplate(DayOfWeek dayOfWeek, int availableSpace, List<PlannerTimeSlotTemplate> slots) {
}
