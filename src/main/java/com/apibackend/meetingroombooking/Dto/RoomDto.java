package com.apibackend.meetingroombooking.Dto;


import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {
    private Long id;


    @NotBlank(message = "Name is required")
    private String name;


    private String location;


    @Min(1)
    private int capacity;
}