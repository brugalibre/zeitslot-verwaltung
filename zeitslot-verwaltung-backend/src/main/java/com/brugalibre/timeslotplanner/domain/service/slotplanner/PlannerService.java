package com.brugalibre.timeslotplanner.domain.service.slotplanner;

import com.brugalibre.timeslotplanner.domain.model.processor.PlannerProcessor;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.Planner;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.PlannerDay;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
@AllArgsConstructor
public class PlannerService {

   private final List<PlannerProcessor> plannerProcessors;

   public Planner calculatePlanner(LocalDate beginnDate, LocalDate endDate) {
      requireNonNull(beginnDate, "beginnDate must not be null!");
      requireNonNull(endDate, "endDate must not be null!");
      int days = beginnDate.until(endDate).getDays();
      return calculatePlanner(beginnDate, days);
   }

   public Planner calculatePlanner(LocalDate beginnDate, int days) {
      requireNonNull(beginnDate, "beginnDate must not be null!");
      List<PlannerDay> plannerDays = buildRawPlanner(beginnDate, days);
      Planner planner = Planner.builder()
              .days(plannerDays)
              .build();
      return processPlanner(planner);
   }

   private static List<PlannerDay> buildRawPlanner(LocalDate beginDate, int days) {
      LocalDate nextDay = beginDate;
      List<PlannerDay> plannerDays = new ArrayList<>(days);
      plannerDays.add(buildPlannerDay(nextDay));
      for (int i = 0; i < days; i++) {
         nextDay = nextDay.plusDays(1);
         plannerDays.add(buildPlannerDay(nextDay));
      }
      plannerDays.sort(Comparator.comparing(PlannerDay::date));
      return plannerDays;
   }

   private static PlannerDay buildPlannerDay(LocalDate nextDay) {
      return PlannerDay.builder()
              .date(nextDay)
              .timeSlots(List.of())
              .build();
   }

   private Planner processPlanner(Planner planner) {
      plannerProcessors.sort(Comparator.comparing(PlannerProcessor::order));
      for (PlannerProcessor plannerProcessor : plannerProcessors) {
         planner = plannerProcessor.process(planner);
      }
      return planner;
   }
}
