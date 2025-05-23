package com.example.HelloEvents.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idreservation;
    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    public Reservation() {
    }

    public Reservation(Long idreservation, User user, Event event) {
        this.idreservation = idreservation;
        this.user = user;
        this.event = event;
    }

    public Long getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(Long idreservation) {
        this.idreservation = idreservation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
