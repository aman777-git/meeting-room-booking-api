package com.apibackend.meetingroombooking.service;


import com.apibackend.meetingroombooking.Dto.RoomDto;
import com.apibackend.meetingroombooking.exception.ResourceNotFoundException;
import com.apibackend.meetingroombooking.model.Room;
import com.apibackend.meetingroombooking.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;


    public RoomDto createRoom(RoomDto dto) {
        Room room = Room.builder()
                .name(dto.getName())
                .location(dto.getLocation())
                .capacity(dto.getCapacity())
                .build();
        room = roomRepository.save(room);
        dto.setId(room.getId());
        return dto;
    }


    public List<RoomDto> listRooms() {
        return roomRepository.findAll().stream().map(r -> RoomDto.builder()
                .id(r.getId())
                .name(r.getName())
                .location(r.getLocation())
                .capacity(r.getCapacity())
                .build()).collect(Collectors.toList());
    }


    public Room getRoomEntity(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
    }
}