package com.brugalibre.timeslotplanner.domain.model.vacation;

import lombok.Builder;

import java.util.List;

/**
 * {@link BusinessVacations} defines the list of vacations for a business
 *
 * @param vacations
 */
@Builder
public record BusinessVacations(List<BusinessVacation> vacations) {
   public List<BusinessVacation> getBusinessVacations() {
      return vacations;
   }
}
