package com.apibackend.meetingroombooking.repository;


import com.apibackend.meetingroombooking.model.Booking;
import com.apibackend.meetingroombooking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRoomAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(Room room, LocalDateTime end, LocalDateTime start);
    List<Booking> findByRoom(Room room);
    List<Booking> findByStartTimeBetween(LocalDateTime from, LocalDateTime to);
}