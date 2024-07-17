package com.brugalibre.timeslotplanner.domain.model.slotplanner.bookedslots;

import com.brugalibre.common.domain.model.DomainModel;
import com.brugalibre.domain.user.model.User;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.TimeSlot;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * A {@link BookedTimeSlot} defines a {@link TimeSlot} which was booked by an {@link User}
 *
 * @param id     the id of the {@link BookedTimeSlot}
 * @param userId the id of the {@link User} who has booked the slot
 * @param beginn the beginn of the {@link BookedTimeSlot}
 * @param end    the end time of the {@link BookedTimeSlot}
 */
@Builder
public record BookedTimeSlot(String id, String userId, LocalDateTime beginn, LocalDateTime end) implements DomainModel {

   @Override
   public String getId() {
      return this.id;
   }

}
