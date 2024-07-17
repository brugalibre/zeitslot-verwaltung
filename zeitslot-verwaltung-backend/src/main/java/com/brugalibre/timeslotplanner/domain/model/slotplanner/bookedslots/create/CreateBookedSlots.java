package com.brugalibre.timeslotplanner.domain.model.slotplanner.bookedslots.create;

import java.util.List;

public record CreateBookedSlots(String userId, List<CreateBookedSlot> createBookedSlots) {
}
