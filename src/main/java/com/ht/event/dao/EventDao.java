package com.ht.event.dao;

import com.ht.event.model.Event;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tanvigupta on 28/06/17.
 */
public interface EventDao {
    void addEvent(Event event);

    void updateEvent(Event event);

    Event getEvent(Integer id);

    void deleteEvent(Integer id);

    List<Event> getEvents();
}
