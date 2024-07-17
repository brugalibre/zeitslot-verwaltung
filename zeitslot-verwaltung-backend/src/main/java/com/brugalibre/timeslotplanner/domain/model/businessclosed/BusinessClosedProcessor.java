package com.brugalibre.timeslotplanner.domain.model.businessclosed;

import com.brugalibre.timeslotplanner.domain.model.processor.PlannerProcessor;
import com.brugalibre.timeslotplanner.domain.model.processor.ProcessorConst;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.Availability;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.Planner;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.PlannerDay;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@link BusinessClosedProcessor} marks certain {@link PlannerDay} as unavailable due to holidays or vacations
 */

@Service
@AllArgsConstructor
public class BusinessClosedProcessor implements PlannerProcessor {

   private final List<BusinessClosedDaysProvider> businessClosedDaysProviders;

   @Override
   public int order() {
      return ProcessorConst.BUSINESS_VACATION;
   }

   @Override
   public Planner process(Planner planner) {
      List<BusinessClosedDay> closedDays = getClosedDays();
      List<PlannerDay> days = new ArrayList<>(planner.days().size());
      planner.days().forEach(plannerDay -> {
         BusinessClosedDay businessClosedDay = getBusinessClosedDay(plannerDay, closedDays);
         PlannerDay processedPlannerDay = plannerDay;
         if (businessClosedDay != null) {
            processedPlannerDay = setPlannerDayUnavailable(plannerDay, businessClosedDay);
         }
         days.add(processedPlannerDay);
      });
      return planner.toBuilder()
              .days(days)
              .build();
   }

   private static BusinessClosedDay getBusinessClosedDay(PlannerDay plannerDay, List<BusinessClosedDay> closedDays) {
      return closedDays.stream()
              .filter(businessClosedDay -> businessClosedDay.date().equals(plannerDay.date()))
              .findFirst()
              .orElse(null);
   }

   private static PlannerDay setPlannerDayUnavailable(PlannerDay plannerDay, BusinessClosedDay businessClosedDay) {
      return plannerDay.toBuilder()
              .availability(new Availability(false, businessClosedDay.businessClosedReason()))
              .build();
   }

   private List<BusinessClosedDay> getClosedDays() {
      return businessClosedDaysProviders.stream()
              .map(BusinessClosedDaysProvider::businessClosedDays)
              .flatMap(List::stream)
              .toList();
   }
}
