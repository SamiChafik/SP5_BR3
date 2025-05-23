package com.example.HelloEvents.repository;

import com.example.HelloEvents.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation , Long> {
}
