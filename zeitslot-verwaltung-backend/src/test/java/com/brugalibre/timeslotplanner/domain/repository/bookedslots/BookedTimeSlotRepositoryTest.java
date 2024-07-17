package com.brugalibre.timeslotplanner.domain.repository.bookedslots;

import com.brugalibre.timeslotplanner.app.config.TimeSlotManagementTestConfig;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.bookedslots.BookedTimeSlot;
import com.brugalibre.timeslotplanner.domain.repository.planner.bookedslots.BookedTimeSlotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TimeSlotManagementTestConfig.class)
class BookedTimeSlotRepositoryTest {

   @Autowired
   private BookedTimeSlotRepository bookedTimeSlotRepository;

   @Test
   void calculatePlanner() {
      // Given
      LocalDateTime beginn = LocalDateTime.of(LocalDate.of(2024, 1, 1), LocalTime.of(10, 15));
      LocalDateTime end = beginn.plusHours(2);
      BookedTimeSlot bookedTimeSlot = BookedTimeSlot.builder()
              .userId("234")
              .beginn(beginn)
              .end(end)
              .build();

      // When
      BookedTimeSlot savedBookedTimeSlot = bookedTimeSlotRepository.save(bookedTimeSlot);
      BookedTimeSlot persistedBookedTimeSlot = bookedTimeSlotRepository.getById(savedBookedTimeSlot.id());

      // Then
      assertThat(savedBookedTimeSlot).isEqualTo(persistedBookedTimeSlot);
   }

}