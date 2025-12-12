package com.apibackend.meetingroombooking.Dto;


import jakarta.validation.constraints.*;
import lombok.*;


import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {
    private Long id;


    @NotNull
    private Long roomId;


    @NotBlank
    private String organiser;


    @NotNull
    private LocalDateTime startTime;


    @NotNull
    private LocalDateTime endTime;


    private String purpose;
}