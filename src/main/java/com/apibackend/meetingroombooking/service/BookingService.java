package com.apibackend.meetingroombooking.service;

import com.apibackend.meetingroombooking.Dto.BookingDto;
import com.apibackend.meetingroombooking.exception.ResourceNotFoundException;
import com.apibackend.meetingroombooking.model.Booking;
import com.apibackend.meetingroombooking.model.Room;
import com.apibackend.meetingroombooking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomService roomService;

    public BookingDto createBooking(BookingDto dto) {

        // Fetch room
        Room room = roomService.getRoomEntity(dto.getRoomId());

        // Check for conflicting bookings
        List<Booking> conflicts = bookingRepository
                .findByRoomAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
                        room,
                        dto.getEndTime(),
                        dto.getStartTime()
                );

        if (!conflicts.isEmpty()) {
            throw new IllegalArgumentException("Time slot not available for this room.");
        }

        // Save new booking
        Booking booking = Booking.builder()
                .room(room)
                .organiser(dto.getOrganiser())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .purpose(dto.getPurpose())
                .build();

        booking = bookingRepository.save(booking);

        // Set generated ID back to DTO
        dto.setId(booking.getId());

        return dto;
    }

    public List<BookingDto> listBookings() {
        return bookingRepository.findAll().stream()
                .map(b -> BookingDto.builder()
                        .id(b.getId())
                        .roomId(b.getRoom().getId())
                        .organiser(b.getOrganiser())
                        .startTime(b.getStartTime())
                        .endTime(b.getEndTime())
                        .purpose(b.getPurpose())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
