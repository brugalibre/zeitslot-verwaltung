package com.brugalibre.timeslotplanner.app.config;

import com.brugalibre.common.domain.app.config.CommonAppPersistenceConfig;
import com.brugalibre.timeslotplanner.app.TimeSlotManagementRestAppConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@EnableAutoConfiguration
//@TestPropertySource(locations = "classpath:application-test.yaml")
@ActiveProfiles("test")
@Configuration
@Import({TimeSlotManagementRestAppConfig.class, CommonAppPersistenceConfig.class})
public class TimeSlotManagementTestConfig {
}
