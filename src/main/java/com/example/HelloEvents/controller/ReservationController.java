package com.example.HelloEvents.controller;

import com.example.HelloEvents.dto.ReservationDto;
import com.example.HelloEvents.services.ResrvationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservation")
@CrossOrigin("*")
public class ReservationController {
    public ReservationController(ResrvationService resrvationService) {
        this.resrvationService = resrvationService;
    }

    public ResrvationService resrvationService;

    @PostMapping
    public ReservationDto addReservation(@RequestBody ReservationDto reservationDto) {
        return resrvationService.Resrever(reservationDto);
    }

    @GetMapping("/allReservations")
    public List<ReservationDto> getAllReservations() {
        return resrvationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public ReservationDto getreservationById(@PathVariable Long id) {
        return resrvationService.getReservationById(id);
    }
}
