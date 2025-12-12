package com.apibackend.meetingroombooking.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;


@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column(nullable = false, unique = true)
        private String name;


        private String location;


        private int capacity;


        @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
        private Set<Booking> bookings;
    }
