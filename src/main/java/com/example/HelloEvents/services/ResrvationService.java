package com.example.HelloEvents.services;

import com.example.HelloEvents.dto.ReservationDto;
import com.example.HelloEvents.mapper.ReservationMapper;
import com.example.HelloEvents.repositories.UserRepository;
import com.example.HelloEvents.repositories.EventRepository;
import com.example.HelloEvents.repositories.ReservationRepository;
import com.example.HelloEvents.entities.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ResrvationService {


    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private ReservationMapper reservationMapper;

    public ResrvationService(ReservationRepository reservationRepository, UserRepository userRepository, EventRepository eventRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.reservationMapper = reservationMapper;
    }

    @Transactional
    public ReservationDto Resrever(ReservationDto reservationDto){
        var user = userRepository.findById(reservationDto.getUserId()).orElse(null);
        var event = eventRepository.findById(reservationDto.getEventId()).orElse(null);

        var res = reservationRepository.save(new Reservation(null,user,event));
        return new ReservationDto(res.getIdreservation(), res.getUser().getId(), res.getEvent().getIdEvent());
    }

    public List<ReservationDto>  getAllReservation(){
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservationMapper::reservationToDto).collect(Collectors.toList());
    }

    public ReservationDto getReservationById(Long id){
        return reservationRepository.findById(id)
                .map(ress->reservationMapper.reservationToDto(ress))
                .orElseThrow(()->new RuntimeException("Reservation Not Found"));
    }



}
