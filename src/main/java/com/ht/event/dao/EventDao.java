package com.ht.event.dao;

import com.ht.event.model.Event;
import com.ht.event.model.EventDTO;

import java.util.List;

public interface EventDao {
    void addEvent(Event event);

    void updateEvent(Event event);

    Event getEvent(Integer id);

    void deleteEvent(Integer id);

    List<Event> getEvents(EventDTO eventDTO);

    void indexEvents() throws Exception;

    List<Event> searchForEvent(String searchText) throws Exception;
}
