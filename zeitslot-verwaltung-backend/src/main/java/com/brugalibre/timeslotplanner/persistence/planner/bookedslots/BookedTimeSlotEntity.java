package com.brugalibre.timeslotplanner.persistence.planner.bookedslots;

import com.brugalibre.common.domain.persistence.DomainEntity;
import com.brugalibre.timeslotplanner.persistence.planner.TimeSlotEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "booked_time_slot")
public class BookedTimeSlotEntity extends DomainEntity {

   @NotNull
   @Column(name = "user_id")
   private String userId;

   @OneToMany(targetEntity = TimeSlotEntity.class,
           mappedBy = "weeklyCoursesEntity",
           cascade = CascadeType.ALL,
           fetch = FetchType.EAGER,
           orphanRemoval = true)
   @NotNull
   private List<TimeSlotEntity> timeSlots;

   public BookedTimeSlotEntity(String id) {
      super(id);
      this.timeSlots = new ArrayList<>();
   }

   public BookedTimeSlotEntity() {
      this(null);
   }
}
