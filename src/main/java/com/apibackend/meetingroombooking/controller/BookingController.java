package com.apibackend.meetingroombooking.controller;

import com.apibackend.meetingroombooking.Dto.BookingDto;
import com.apibackend.meetingroombooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@Validated @RequestBody BookingDto dto) {
        return ResponseEntity.ok(bookingService.createBooking(dto));
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> listBookings() {
        return ResponseEntity.ok(bookingService.listBookings());
    }
}
