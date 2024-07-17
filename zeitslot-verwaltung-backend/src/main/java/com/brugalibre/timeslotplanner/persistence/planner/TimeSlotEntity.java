package com.brugalibre.timeslotplanner.persistence.planner;

import com.brugalibre.common.domain.persistence.DomainEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "time_slot")
public class TimeSlotEntity extends DomainEntity {

   public TimeSlotEntity() {
      this(null);
   }

   public TimeSlotEntity(String id) {
      super(id);
   }

   @NotNull
   private LocalDateTime beginn;

   @NotNull
   private LocalDateTime end;
}
