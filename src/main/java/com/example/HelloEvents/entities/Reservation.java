package com.example.HelloEvents.entities;

import jakarta.persistence.*;

@Entity

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long reservation_id;
    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    public Reservation() {
    }

    public Reservation(Long reservation_id, User user, Event event) {
        this.reservation_id = reservation_id;
        this.user = user;
        this.event = event;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long idreservation) {
        this.reservation_id = idreservation;
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
