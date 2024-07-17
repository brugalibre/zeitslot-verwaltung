package com.brugalibre.timeslotplanner.domain.repository.vacation.impl;

import com.brugalibre.timeslotplanner.app.ConfigYamlFilePaths;
import com.brugalibre.timeslotplanner.domain.model.vacation.BusinessVacations;
import com.brugalibre.timeslotplanner.domain.repository.vacation.BusinessVacationRepository;
import com.brugalibre.util.file.json.JsonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class HardCodedBusinessVacationRepositoryImpl implements BusinessVacationRepository {

   private final ConfigYamlFilePaths configYamlFilePaths;
   private final JsonService jsonService = new JsonService();

   @Override
   public BusinessVacations getBusinessVacations() {
      return jsonService.readJson(configYamlFilePaths.getBusinessVacationsFile(), BusinessVacations.class);
   }
}
