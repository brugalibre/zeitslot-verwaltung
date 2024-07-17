package com.brugalibre.timeslotplanner.persistence.planner.bookedslots;

import com.brugalibre.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookedTimeSlotDao extends CrudRepository<BookedTimeSlotEntity, String> {
   /**
    * Returns a list of {@link BookedTimeSlotEntity} which belongs to the given user id
    *
    * @param userId the id of the {@link User}
    * @return a list of {@link BookedTimeSlotEntity} which belongs to the given user id
    */
   List<BookedTimeSlotEntity> getByUserId(String userId);
}
