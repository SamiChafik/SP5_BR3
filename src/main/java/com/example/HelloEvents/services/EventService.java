package com.example.HelloEvents.services;

import com.example.HelloEvents.dto.EventDto;
import com.example.HelloEvents.mapper.EventMapper;
import com.example.HelloEvents.repositories.EventRepository;
import com.example.HelloEvents.entities.Event;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private EventMapper eventMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Transactional
    public EventDto AddEvent(EventDto eventDto) {
        return eventMapper.eventToDto(eventRepository.save(eventMapper.dtoToEvent(eventDto)));
    }

    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(event ->eventMapper.eventToDto(event))
                .toList();
    }

    public EventDto getEventById(Long id){
        return eventRepository.findById(id)
                .map(evenement -> eventMapper.eventToDto(evenement))
                .orElseThrow(()->new RuntimeException("event not found"));
    }

    public EventDto updateEvent(Long id , EventDto eventDto) {
        Event ev = eventRepository.findById(id).get();
                ev.setEventname(eventDto.getEventname());
                ev.setType(eventDto.getType());
                ev.setDescription(eventDto.getDescription());

                return eventMapper.eventToDto(eventRepository.save(eventMapper.dtoToEvent(eventDto)));
    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }




}
