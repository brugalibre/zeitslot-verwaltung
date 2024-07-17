package com.brugalibre.timeslotplanner.domain.model.slotplanner;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record Planner(List<PlannerDay> days) {

}
