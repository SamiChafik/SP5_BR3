package com.example.HelloEvents.repository;

import com.example.HelloEvents.dto.Result;
import com.example.HelloEvents.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "select", nativeQuery = true)
    List<Result> findBy(Long id);

}
