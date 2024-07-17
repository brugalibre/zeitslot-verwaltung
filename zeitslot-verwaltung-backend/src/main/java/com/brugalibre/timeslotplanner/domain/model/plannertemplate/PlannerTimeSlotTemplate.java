package com.brugalibre.timeslotplanner.domain.model.plannertemplate;

import com.brugalibre.timeslotplanner.domain.model.slotplanner.services.ProvidedService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import java.time.LocalTime;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record PlannerTimeSlotTemplate(
        @JsonDeserialize(using = LocalTimeDeserializer.class) LocalTime begin,
        @JsonDeserialize(using = LocalTimeDeserializer.class) LocalTime end,
        List<ProvidedService> providedServices,
        int availableSpace) {
}
