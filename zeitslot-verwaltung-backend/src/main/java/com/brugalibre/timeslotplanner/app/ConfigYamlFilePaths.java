package com.brugalibre.timeslotplanner.app;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * The {@link ConfigYamlFilePaths} contains paths of various configuration-yaml files which differs between develop-files
 * and production files. The actual path is read from the application.yaml file which used for starting the application
 * <p>
 */
@Getter
public class ConfigYamlFilePaths {
   private static final Logger LOG = LoggerFactory.getLogger(ConfigYamlFilePaths.class);
   private final List<String> templatePlannerFiles;
   private final String businessVacationsFile;

   public ConfigYamlFilePaths(List<String> templatePlannerFiles, String businessVacationsFile) {
      this.templatePlannerFiles = templatePlannerFiles;
      this.businessVacationsFile = businessVacationsFile;
      LOG.info("Using value {} for 'templatePlannerFiles' and value {} for businessVacationsFile", templatePlannerFiles, businessVacationsFile);
   }
}
