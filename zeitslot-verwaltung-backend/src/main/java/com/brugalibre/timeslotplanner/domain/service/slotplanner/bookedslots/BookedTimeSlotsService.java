package com.brugalibre.timeslotplanner.domain.service.slotplanner.bookedslots;

import com.brugalibre.timeslotplanner.domain.model.slotplanner.bookedslots.BookedTimeSlot;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.bookedslots.create.CreateBookedSlots;
import com.brugalibre.timeslotplanner.domain.repository.planner.bookedslots.BookedTimeSlotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BookedTimeSlotsService {

   private final BookedTimeSlotRepository bookedTimeSlotRepository;

   public List<BookedTimeSlot> createBookedTimeSlots(CreateBookedSlots createBookedSlots) {
      createBookedSlots.createBookedSlots().stream()
              .map(createBookedSlot -> {
                 BookedTimeSlot bookedTimeSlot = BookedTimeSlot.builder()
                         .userId(createBookedSlots.userId())
                         .beginn(LocalDateTime.of(createBookedSlot.date(), createBookedSlot.timeSlot().beginn()))
                         .end(LocalDateTime.of(createBookedSlot.date(), createBookedSlot.timeSlot().end()))
                         .build();
                 bookedTimeSlotRepository.save(bookedTimeSlot);
              });;
      return List.of();
   }
}
