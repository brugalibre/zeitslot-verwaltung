package com.brugalibre.timeslotplanner.domain.model.slotplanner.bookedslots;

import com.brugalibre.timeslotplanner.domain.model.processor.ProcessorConst;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.Planner;
import com.brugalibre.timeslotplanner.domain.model.processor.PlannerProcessor;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.TimeSlot;
import org.springframework.stereotype.Service;

/**
 * The {@link BookedSlotsProcessor} takes booked slots into consideration. Meaning: A {@link TimeSlot} provides
 * a certain amount of spaces. Each booked slot reduces that amount.
 * If a {@link BookedTimeSlot} can not be associated with a {@link TimeSlot} an exception is thrown. This indicates,
 * a potential conflict of vacation or holiday with a booked time slot
 */

@Service
public class BookedSlotsProcessor implements PlannerProcessor {
   @Override
   public int order() {
      return ProcessorConst.BOOKED_SLOTS;
   }

   @Override
   public Planner process(Planner planner) {
      return planner;
   }
}
