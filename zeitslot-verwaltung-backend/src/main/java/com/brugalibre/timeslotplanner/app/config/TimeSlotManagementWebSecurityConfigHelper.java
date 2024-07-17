package com.brugalibre.timeslotplanner.app.config;

import com.brugalibre.common.security.auth.config.WebSecurityConfigHelper;
import com.brugalibre.persistence.user.Role;
import org.springframework.stereotype.Service;

@Service
public class TimeSlotManagementWebSecurityConfigHelper implements WebSecurityConfigHelper {
   @Override
   public String[] getRequestMatcherForRole(String role) {
      if (Role.ADMIN.name().equals(role)) {
         return new String[]{"/api/v1/time-slot-management/admin/**"};
      } else if (Role.USER.name().equals(role)) {
         return new String[]{"/api/v1/time-slot-management/**"};
      }
      return new String[]{};
   }

   @Override
   public String getLoginProcessingUrl() {
      return "/zeitslot-verwaltung";
   }
}
