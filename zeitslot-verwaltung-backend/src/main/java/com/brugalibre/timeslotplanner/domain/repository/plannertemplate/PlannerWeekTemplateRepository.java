package com.brugalibre.timeslotplanner.domain.repository.plannertemplate;

import com.brugalibre.timeslotplanner.domain.model.plannertemplate.PlannerWeekTemplate;

import java.util.List;

public interface PlannerWeekTemplateRepository {

   List<PlannerWeekTemplate> getAll();
}
