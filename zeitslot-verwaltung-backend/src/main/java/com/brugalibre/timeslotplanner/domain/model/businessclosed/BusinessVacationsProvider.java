package com.brugalibre.timeslotplanner.domain.model.businessclosed;

import com.brugalibre.timeslotplanner.domain.model.vacation.BusinessVacation;
import com.brugalibre.timeslotplanner.domain.model.vacation.BusinessVacations;
import com.brugalibre.timeslotplanner.domain.repository.vacation.BusinessVacationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BusinessVacationsProvider implements BusinessClosedDaysProvider {
   private final BusinessVacationRepository businessVacationRepository;

   @Override
   public List<BusinessClosedDay> businessClosedDays() {
      BusinessVacations businessVacations = businessVacationRepository.getBusinessVacations();
      return businessVacations.vacations().stream()
              .map(BusinessVacationsProvider::getVacationDays)
              .flatMap(List::stream)
              .toList();
   }

   private static List<BusinessClosedDay> getVacationDays(BusinessVacation businessVacation) {
      LocalDate vacationDay = businessVacation.beginn();
      List<BusinessClosedDay> vacations = new ArrayList<>();
      vacations.add(new BusinessClosedDay(vacationDay, BusinessClosedReason.BUSINESS_VACATION));
      while (!vacationDay.equals(businessVacation.end())) {
         vacationDay = vacationDay.plusDays(1);
         vacations.add(new BusinessClosedDay(vacationDay, BusinessClosedReason.BUSINESS_VACATION));
      }
      return vacations;
   }
}
