package com.example.HelloEvents.dto;

public class ReservationDto {
    Long reservation_id;
     Long user_id;
     Long event_id;

    public ReservationDto() {
    }

    public ReservationDto(Long idReservation, Long user_id, Long event_id) {
        this.reservation_id = idReservation;
        this.user_id = user_id;
        this.event_id = event_id;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }
}
