package com.example.HelloEvents.mapper;

import com.example.HelloEvents.dto.ReservationDto;
import com.example.HelloEvents.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    //@Mapping(source = "idreservation", target = "idReservation")
    ReservationDto reservationToDto(Reservation reservation);
    Reservation DtoToReservation(ReservationDto dto);


}
