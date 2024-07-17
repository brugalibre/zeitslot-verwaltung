package com.brugalibre.timeslotplanner.app.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {
   private final boolean dropFirst;
   private final DataSource dataSource;

   public LiquibaseConfig(@Value("${spring.liquibase.dropFirst}") boolean dropFirst, DataSource dataSource) {
      this.dropFirst = dropFirst;
      this.dataSource = dataSource;
   }

   @Bean
   public SpringLiquibase liquibase() {
      SpringLiquibase springLiquibase = new SpringLiquibase();
      springLiquibase.setChangeLog("classpath:liquibase/changelog-config.xml");
      springLiquibase.setDataSource(dataSource);
      springLiquibase.setDropFirst(dropFirst);
      return springLiquibase;
   }
}
