package com.brugalibre.timeslotplanner.domain.repository.plannertemplate.impl;

import com.brugalibre.timeslotplanner.app.ConfigYamlFilePaths;
import com.brugalibre.timeslotplanner.domain.model.plannertemplate.PlannerWeekTemplate;
import com.brugalibre.timeslotplanner.domain.repository.plannertemplate.PlannerWeekTemplateRepository;
import com.brugalibre.util.file.json.JsonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class HardCodedPlannerWeekTemplateRepositoryImpl implements PlannerWeekTemplateRepository {

   private final ConfigYamlFilePaths configYamlFilePaths;
   private final JsonService jsonService = new JsonService();

   @Override
   public List<PlannerWeekTemplate> getAll() {
      return configYamlFilePaths.getTemplatePlannerFiles()
              .stream()
              .map(templateFile -> jsonService.readJson(templateFile, PlannerWeekTemplate.class))
              .sorted(Comparator.comparing(PlannerWeekTemplate::validFrom))
              .toList();
   }
}
