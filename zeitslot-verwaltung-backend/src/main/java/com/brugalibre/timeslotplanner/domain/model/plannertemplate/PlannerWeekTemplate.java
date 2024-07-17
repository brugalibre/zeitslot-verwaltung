package com.brugalibre.timeslotplanner.domain.model.plannertemplate;

import com.brugalibre.timeslotplanner.domain.model.slotplanner.PlannerDay;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Builder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Builder
public record PlannerWeekTemplate(
        @JsonDeserialize(using = LocalDateDeserializer.class) @JsonFormat(pattern = "dd.MM.yyyy") LocalDate validFrom,
        @JsonDeserialize(using = LocalDateDeserializer.class) @JsonFormat(pattern = "dd.MM.yyyy") LocalDate validUpto,
        List<PlannerDayTemplate> days) {

   /**
    * Returns an {@link Optional} {@link PlannerDayTemplate} if this {@link PlannerWeekTemplate} has a {@link PlannerDayTemplate} for the given {@link DayOfWeek}. Otherwise, returns an {@link Optional#empty()}
    *
    * @param plannerDay the {@link PlannerDay} to check if its {@link DayOfWeek} is contained within this {@link PlannerWeekTemplate}
    * @return an {@link Optional} {@link PlannerDayTemplate} if this {@link PlannerWeekTemplate} has a {@link PlannerDayTemplate} for the given {@link DayOfWeek}. Otherwise, returns an {@link Optional#empty()}
    */
   public Optional<PlannerDayTemplate> findPlannerDayTemplate(PlannerDay plannerDay) {
      return days.stream()
              .filter(plannerDayTemplate -> plannerDayTemplate.dayOfWeek() == plannerDay.getDayOfWeek())
              .findFirst();
   }
}
