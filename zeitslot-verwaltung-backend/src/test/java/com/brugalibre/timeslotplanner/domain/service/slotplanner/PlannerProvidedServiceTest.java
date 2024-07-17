package com.brugalibre.timeslotplanner.domain.service.slotplanner;

import com.brugalibre.timeslotplanner.app.config.TimeSlotManagementTestConfig;
import com.brugalibre.timeslotplanner.domain.model.processor.PlannerProcessor;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.services.ProvidedService;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.Planner;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.PlannerDay;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.TimeSlot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TimeSlotManagementTestConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlannerProvidedServiceTest {

   @Autowired
   private List<PlannerProcessor> plannerProcessors;

   @Test
   void calculatePlanner() {
      // Given
      PlannerService plannerService = new PlannerService(plannerProcessors);
      int expectedPlannerDays = 13;// No Sundays
      LocalDate beginDate = LocalDate.of(2024, 1, 1);
      int days = 15;
      LocalDate endDate = beginDate.plusDays(days);
      List<LocalDate> vacationDays = List.of(LocalDate.of(2024, 1, 10),
              LocalDate.of(2024, 1, 11),
              LocalDate.of(2024, 1, 12),
              LocalDate.of(2024, 1, 15)); // no 14. january -> is sunday

      // When
      Planner actualPlanner = plannerService.calculatePlanner(beginDate, endDate);

      // Then
      assertThat(actualPlanner).isNotNull();
      assertThat(actualPlanner.days().size()).isEqualTo(expectedPlannerDays);
      List<PlannerDay> unavailableDays = actualPlanner.days().stream()
              .filter(plannerDay -> plannerDay.availability() != null && !plannerDay.availability().isAvailable())
              .toList();
      assertThat(unavailableDays.stream().map(PlannerDay::date).toList()).isEqualTo(vacationDays);
      List<TimeSlot> timeSlots = actualPlanner.days().getFirst().timeSlots();
      List<ProvidedService> providedServices = timeSlots.getFirst().providedServices();
      assertThat(providedServices.size()).isEqualTo(2);
   }
}