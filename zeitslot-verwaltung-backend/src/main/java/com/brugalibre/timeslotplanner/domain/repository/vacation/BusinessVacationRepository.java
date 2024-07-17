package com.brugalibre.timeslotplanner.domain.repository.vacation;

import com.brugalibre.timeslotplanner.domain.model.vacation.BusinessVacations;

public interface BusinessVacationRepository {

   /**
    * @return the {@link BusinessVacations} There can only be one
    */
   BusinessVacations getBusinessVacations();
}
