package com.example.HelloEvents.repositories;

import com.example.HelloEvents.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation , Long> {

    Long getCountOfReservationsByEvent_IdEvent(Long eventIdEvent);
}
