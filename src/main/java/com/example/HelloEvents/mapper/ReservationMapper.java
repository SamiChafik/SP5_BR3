package com.example.HelloEvents.mapper;

import com.example.HelloEvents.dto.ReservationDto;
import com.example.HelloEvents.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    @Mapping(source = "reservation.reservation_id", target = "reservation_id")
    @Mapping(source = "reservation.user.id", target = "user_id")
    @Mapping(source = "reservation.event.event_id", target = "event_id")
    ReservationDto reservationToDto(Reservation reservation);



    Reservation DtoToReservation(ReservationDto dto);


}
