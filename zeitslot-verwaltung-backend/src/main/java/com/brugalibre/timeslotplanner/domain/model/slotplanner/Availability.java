package com.brugalibre.timeslotplanner.domain.model.slotplanner;

import com.brugalibre.timeslotplanner.domain.model.businessclosed.BusinessClosedReason;

public record Availability(boolean isAvailable, BusinessClosedReason businessClosedReason) {
}
