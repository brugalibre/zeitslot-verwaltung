package com.brugalibre.timeslotplanner.domain.model.businessclosed;

import java.util.List;

/**
 * A {@link BusinessClosedDaysProvider} provides the days during which the business is closed. A business can be closed
 * due to regional and national wide holidays or due to private vacations
 */
public interface BusinessClosedDaysProvider {

   /**
    * The days during which the business is closed
    *
    * @return the days during which the business is closed
    */
   List<BusinessClosedDay> businessClosedDays();
}
