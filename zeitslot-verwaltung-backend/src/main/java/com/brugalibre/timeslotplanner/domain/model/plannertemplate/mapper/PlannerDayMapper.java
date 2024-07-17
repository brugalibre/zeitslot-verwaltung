package com.brugalibre.timeslotplanner.domain.model.plannertemplate.mapper;

import com.brugalibre.timeslotplanner.domain.model.plannertemplate.PlannerDayTemplate;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.PlannerDay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannerDayMapper {
   private final TimeSlotMapper timeSlotMapper;

   public PlannerDay mapToPlannerDay(PlannerDayTemplate plannerDayTemplate, PlannerDay plannerDay) {
      return plannerDay.toBuilder()
              .timeSlots(timeSlotMapper.mapTimeSlotTemplateToTemplate(plannerDayTemplate.slots()))
              .build();
   }
}
