package com.example.HelloEvents.mapper;

import com.example.HelloEvents.dto.ReservationDto;
import com.example.HelloEvents.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    @Mapping(source = "reservation.idreservation", target = "idReservation")
    @Mapping(source = "reservation.user.id", target = "userId")
    @Mapping(source = "reservation.event.idEvent", target = "eventId")
    ReservationDto reservationToDto(Reservation reservation);



    Reservation DtoToReservation(ReservationDto dto);


}
