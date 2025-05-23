package com.example.HelloEvents.mapper;

import com.example.HelloEvents.dto.EventDto;
import com.example.HelloEvents.entities.Event;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" ,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    EventDto eventToDto(Event event);
    Event dtoToEvent(EventDto eventDto);
}
