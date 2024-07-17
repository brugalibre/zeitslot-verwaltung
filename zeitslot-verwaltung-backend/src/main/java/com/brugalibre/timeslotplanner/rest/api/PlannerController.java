package com.brugalibre.timeslotplanner.rest.api;

import com.brugalibre.timeslotplanner.domain.model.slotplanner.Planner;
import com.brugalibre.timeslotplanner.domain.service.slotplanner.PlannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RequestMapping("/api/timeslotplanner/v1/planner")
@RestController
@RequiredArgsConstructor
public class PlannerController {

   private final PlannerService plannerService;

   @GetMapping(path = "/calculate-planner/{beginDate}/{endDate}")
   public Planner calculatePlanner(@PathVariable LocalDate beginDate, @PathVariable LocalDate endDate) {
      return plannerService.calculatePlanner(beginDate, endDate);
   }
}
