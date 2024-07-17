package com.brugalibre.timeslotplanner.domain.model.businessclosed;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayProvider implements BusinessClosedDaysProvider {

   @Override
   public List<BusinessClosedDay> businessClosedDays() {
      return List.of();
   }
}
