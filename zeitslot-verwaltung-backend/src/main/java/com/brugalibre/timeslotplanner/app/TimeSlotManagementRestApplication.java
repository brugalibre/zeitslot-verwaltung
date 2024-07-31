package com.brugalibre.timeslotplanner.app;

import com.brugalibre.timeslotplanner.app.exception.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TimeSlotManagementRestApplication {

   public static void main(String[] args) {
      Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());
      SpringApplication.run(TimeSlotManagementRestApplication.class, args);
   }
}
