package com.example.HelloEvents.controller;

import com.example.HelloEvents.dto.EventDto;
import com.example.HelloEvents.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public EventService eventService;

    @PostMapping
    public EventDto addEvent(@RequestBody EventDto eventDto) {
        return eventService.AddEvent(eventDto);
    }
    @GetMapping("/allEvents")
    public List<EventDto> getAllEvents(){

        return eventService.getAllEvents();
    }
    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable Long id ) {

        return  eventService.getEventById(id);
    }
    @PutMapping("{id}")
    public EventDto updatEvent(@PathVariable Long id ,@RequestBody EventDto eventDto) {
        return eventService.updateEvent(id,eventDto);
    }

    @DeleteMapping("{id}")
    public void deleteEvent(@PathVariable Long id ) {
        eventService.deleteEvent(id);
    }




}
