package com.brugalibre.timeslotplanner.domain.model.processor;

import com.brugalibre.timeslotplanner.domain.model.slotplanner.Planner;

/**
 * A {@link PlannerProcessor} and manipulate/processes the {@link Planner} and return a modified instance of that {@link Planner}
 */
public interface PlannerProcessor {
   int order();

   Planner process(Planner planner);
}
