package com.brugalibre.timeslotplanner.domain.repository.planner.bookedslots;

import com.brugalibre.common.domain.repository.CommonDomainRepositoryImpl;
import com.brugalibre.timeslotplanner.domain.model.slotplanner.bookedslots.BookedTimeSlot;
import com.brugalibre.timeslotplanner.domain.repository.bookedslots.mapper.BookedTimeSlotMapperImpl;
import com.brugalibre.timeslotplanner.persistence.planner.bookedslots.BookedTimeSlotDao;
import com.brugalibre.timeslotplanner.persistence.planner.bookedslots.BookedTimeSlotEntity;
import org.springframework.stereotype.Service;

@Service
public class BookedTimeSlotRepository extends CommonDomainRepositoryImpl<BookedTimeSlot, BookedTimeSlotEntity, BookedTimeSlotDao> {
   public BookedTimeSlotRepository(BookedTimeSlotDao domainDao) {
      super(domainDao, new BookedTimeSlotMapperImpl());
   }
}
