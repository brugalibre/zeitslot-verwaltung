package com.brugalibre.timeslotplanner.domain.repository.planner.bookedslots.mapper;

import com.brugalibre.common.domain.mapper.CommonDomainModelMapper;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.bookedslots.BookedTimeSlot;
import com.brugalibre.timeslotplanner.persistence.planner.bookedslots.BookedTimeSlotEntity;
import org.mapstruct.Mapper;

@Mapper
public interface BookedTimeSlotMapper extends CommonDomainModelMapper<BookedTimeSlot, BookedTimeSlotEntity> {
   // no-op
}
