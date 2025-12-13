package com.apibackend.meetingroombooking.controller;

import com.apibackend.meetingroombooking.Dto.RoomDto;
import com.apibackend.meetingroombooking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomDto> createRoom(@Validated @RequestBody RoomDto dto) {
        return ResponseEntity.ok(roomService.createRoom(dto));
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> listRooms() {
        return ResponseEntity.ok(roomService.listRooms());
    }
}
