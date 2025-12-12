package com.apibackend.meetingroombooking.model;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;


    @Column(nullable = false)
    private String organiser;


    @Column(nullable = false)
    private LocalDateTime startTime;


    @Column(nullable = false)
    private LocalDateTime endTime;


    private String purpose;
}
