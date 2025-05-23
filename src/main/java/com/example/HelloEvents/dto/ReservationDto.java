package com.example.HelloEvents.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class ReservationDto {
    Long idReservation;
     Long userId;
     Long eventId;

    public ReservationDto() {
    }

    public ReservationDto(Long idReservation, Long userId, Long eventId) {
        this.idReservation = idReservation;
        this.userId = userId;
        this.eventId = eventId;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
