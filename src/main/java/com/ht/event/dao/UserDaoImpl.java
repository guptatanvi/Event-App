package com.ht.event.dao;

import com.ht.event.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    public void updateUser(User user) {
        User userToUpdate = getUser(user.getId());
        userToUpdate.setId(user.getId());
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPw(user.getPw());
        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setEvents(user.getEvents());

        getCurrentSession().update(userToUpdate);
    }

    public User getUser(Integer id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    public void deleteUser(Integer id) {
        User user = getUser(id);
        if (user != null)
            getCurrentSession().delete(user);
    }

    public List<User> getUsers() {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }
}
