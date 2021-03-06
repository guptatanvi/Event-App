package com.ht.event.dao;

/**
 * Created by tanvigupta on 28/06/17.
 */

import com.ht.event.model.Event;
import com.ht.event.model.EventDTO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EventDaoImpl implements EventDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addEvent(Event event) {
        getCurrentSession().save(event);
    }

    @Override
    public void updateEvent(Event event) {
        Event eventToUpdate = getEvent(event.getId());
        eventToUpdate.setId(event.getId());
        eventToUpdate.setName(event.getName());
        eventToUpdate.setDescription(event.getDescription());
        eventToUpdate.setDate(event.getDate());
        eventToUpdate.setDay(event.getDay());
        eventToUpdate.setDuration(event.getDuration());
        eventToUpdate.setCity(event.getCity());
        eventToUpdate.setAddress(event.getAddress());
        eventToUpdate.setCountry(event.getCountry());
        eventToUpdate.setPincode(event.getPincode());
        eventToUpdate.setLatitude(event.getLatitude());
        eventToUpdate.setLongitude(event.getLongitude());
//        eventToUpdate.setCategories(event.getCategories());
        eventToUpdate.setFees(event.getFees());

        getCurrentSession().update(eventToUpdate);
    }

    @Override
    public Event getEvent(Integer id) {
        return (Event) getCurrentSession().get(Event.class, id);
    }

    @Override
    public void deleteEvent(Integer id) {
        Event event = getEvent(id);
        if (event != null)
            getCurrentSession().delete(event);
    }

    @Override
    public List<Event> getEvents(EventDTO eventDTO) {
        Criteria criteria = getCurrentSession().createCriteria(Event.class);
        criteria.setFirstResult(eventDTO.getStart() * eventDTO.getSize());
        criteria.setMaxResults(eventDTO.getSize());
//        criteria.setFetchSize(5);
        return criteria.list();
    }

    @Transactional
    public void indexEvents() throws Exception
    {
        try
        {
            Session session = sessionFactory.getCurrentSession();

            FullTextSession fullTextSession = Search.getFullTextSession(session);
            fullTextSession.createIndexer().startAndWait();
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    @Transactional
    public List<Event> searchForEvent(String searchText) throws Exception
    {
        try
        {
            Session session = sessionFactory.getCurrentSession();

            FullTextSession fullTextSession = Search.getFullTextSession(session);

            QueryBuilder qb = fullTextSession.getSearchFactory()
                    .buildQueryBuilder().forEntity(Event.class).get();
            org.apache.lucene.search.Query query = qb
                    .keyword().onFields("name")
                    .matching(searchText)
                    .createQuery();

            org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, Event.class);

            List<Event> results = hibQuery.list();
            return results;
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}
