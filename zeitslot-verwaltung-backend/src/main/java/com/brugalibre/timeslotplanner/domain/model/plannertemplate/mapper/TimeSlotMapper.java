package com.brugalibre.timeslotplanner.domain.model.plannertemplate.mapper;

import com.brugalibre.timeslotplanner.domain.model.plannertemplate.PlannerTimeSlotTemplate;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.TimeSlot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeSlotMapper {

   public List<TimeSlot> mapTimeSlotTemplateToTemplate(List<PlannerTimeSlotTemplate> timeSlotTemplates) {
      return timeSlotTemplates.stream()
              .map(timeSlotTemplate -> TimeSlot.builder()
                      .availableSlots(timeSlotTemplate.availableSpace())
                      .providedServices(timeSlotTemplate.providedServices())
                      .end(timeSlotTemplate.end())
                      .begin(timeSlotTemplate.begin())
                      .build())
              .toList();
   }
}
