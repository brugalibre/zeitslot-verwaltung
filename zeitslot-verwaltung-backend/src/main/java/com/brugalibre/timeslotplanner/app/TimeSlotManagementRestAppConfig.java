package com.brugalibre.timeslotplanner.app;

import com.brugalibre.common.domain.app.config.CommonAppPersistenceConfig;
import com.brugalibre.common.security.app.config.CommonAppSecurityConfig;
import com.brugalibre.timeslotplanner.app.config.TimeSlotManagementPersistenceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@ComponentScan(basePackages = {"com.brugalibre.timeslotplanner"})
@Configuration
@Import({TimeSlotManagementPersistenceConfig.class, CommonAppSecurityConfig.class, CommonAppPersistenceConfig.class})
public class TimeSlotManagementRestAppConfig {

   private static final String CONFIG_YAML_FILE_PATHS_BEAN = "configYamlFilePaths";

   @Bean(name = CONFIG_YAML_FILE_PATHS_BEAN)
   public ConfigYamlFilePaths getConfigYamlFilePaths(@Value("${application.configuration.template-planner-files}")
                                                        List<String> templatePlannerFiles,
                                                     @Value("${application.configuration.business-vacations}") String businessVacations) {
      return new ConfigYamlFilePaths(templatePlannerFiles, businessVacations);
   }
}

