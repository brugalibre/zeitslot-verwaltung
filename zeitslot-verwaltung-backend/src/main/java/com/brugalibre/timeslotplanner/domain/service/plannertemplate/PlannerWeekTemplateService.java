package com.brugalibre.timeslotplanner.domain.service.plannertemplate;

import com.brugalibre.util.file.yml.YamlService;
import com.brugalibre.timeslotplanner.domain.model.plannertemplate.PlannerWeekTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlannerWeekTemplateService {
   private final YamlService yamlService;

   public PlannerWeekTemplateService() {
      this.yamlService = new YamlService();
   }

   public List<PlannerWeekTemplate> loadPlannerWeekTemplateFromFile(String path) {

      return List.of(PlannerWeekTemplate.builder()
              .build());
   }
}
