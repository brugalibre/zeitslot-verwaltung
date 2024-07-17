package com.brugalibre.timeslotplanner.app.config;


import com.brugalibre.common.domain.app.config.CommonAppPersistenceConfig;
import com.brugalibre.timeslotplanner.persistence.planner.bookedslots.BookedTimeSlotDao;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {BookedTimeSlotDao.class})
@EntityScan(basePackages = {"com.brugalibre.timeslotplanner.persistence.bookedslots"})
@ComponentScan(basePackages = {"com.brugalibre.timeslotplanner"})
@Import({CommonAppPersistenceConfig.class})
public class TimeSlotManagementPersistenceConfig {
}
