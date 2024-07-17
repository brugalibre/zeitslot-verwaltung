package com.brugalibre.timeslotplanner.domain.model.slotplanner;

import com.brugalibre.common.domain.model.DomainModel;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.services.ProvidedService;
import lombok.Builder;

import java.time.LocalTime;
import java.util.List;

@Builder
public record TimeSlot(String id, List<ProvidedService> providedServices, LocalTime beginn, LocalTime end,
                       int availableSlots) implements DomainModel {
   @Override
   public String getId() {
      return this.id;
   }

}
