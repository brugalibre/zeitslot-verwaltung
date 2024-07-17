package com.brugalibre.timeslotplanner.domain.model.plannertemplate;

import com.brugalibre.timeslotplanner.domain.model.plannertemplate.mapper.PlannerDayMapper;
import com.brugalibre.timeslotplanner.domain.model.processor.PlannerProcessor;
import com.brugalibre.timeslotplanner.domain.model.processor.ProcessorConst;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.Planner;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.PlannerDay;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.TimeSlot;
import com.brugalibre.timeslotplanner.domain.repository.plannertemplate.PlannerWeekTemplateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@link PlannerTemplateProcessor} takes booked slots into consideration. Meaning: A {@link TimeSlot} provides
 * a certain amount of spaces. Each booked slot reduces that amount
 */
@AllArgsConstructor
@Slf4j
@Service
public class PlannerTemplateProcessor implements PlannerProcessor {
   private final PlannerDayMapper plannerDayMapper;
   private final PlannerWeekTemplateRepository plannerWeekTemplateRepository;

   @Override
   public int order() {
      return ProcessorConst.PLANNER_TEMPLATE;
   }

   @Override
   public Planner process(Planner planner) {
      List<PlannerDay> days = new ArrayList<>();
      for (PlannerWeekTemplate plannerWeekTemplate : plannerWeekTemplateRepository.getAll()) {
         for (PlannerDay plannerDay : planner.days()) {
            if (isPlannerValid(plannerDay, plannerWeekTemplate)) {
               plannerWeekTemplate.findPlannerDayTemplate(plannerDay)
                       .ifPresent(plannerDayTemplate -> days.add(plannerDayMapper.mapToPlannerDay(plannerDayTemplate, plannerDay)));
            }
         }
      }
      return planner.toBuilder()
              .days(days)
              .build();
   }

   /**
    * @formatter:off
    * Planner-Days            |--------------------|
    * Template  |-----|  |-----|  |-----|  |-----|   |-----|
    *             1         2        3        4         5
    * The templates 2, 3 & 4 are valid. 1 & 5 are outside the period
    *
    * @formatter:on
    */
   private static boolean isPlannerValid(PlannerDay plannerDay, PlannerWeekTemplate plannerWeekTemplate) {
      return isPlannerBeginBeforeOrEqualValidUpto(plannerDay, plannerWeekTemplate)
              && isPlannerEndAfterOrEqualValidFrom(plannerDay, plannerWeekTemplate);
   }

   private static boolean isPlannerBeginBeforeOrEqualValidUpto(PlannerDay plannerDay, PlannerWeekTemplate plannerWeekTemplate) {
      return plannerDay.date().isBefore(plannerWeekTemplate.validUpto())
              || plannerDay.date().equals(plannerWeekTemplate.validUpto());
   }

   private static boolean isPlannerEndAfterOrEqualValidFrom(PlannerDay plannerDay, PlannerWeekTemplate plannerWeekTemplate) {
      return plannerDay.date().isAfter(plannerWeekTemplate.validFrom())
              || plannerDay.date().equals(plannerWeekTemplate.validFrom());
   }
}
