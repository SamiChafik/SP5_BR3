package com.example.HelloEvents.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long event_id;

    private String eventname;

    private String description;

    private String type;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Reservation> reservations;

    @ManyToOne
    private User user;

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long idEvent) {
        this.event_id = idEvent;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
