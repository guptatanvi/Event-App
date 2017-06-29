package com.ht.event.service;

import java.util.List;

import com.ht.event.model.User;

public interface UserService {
    public void addUser(User user);
    public void updateUser(User user);
    public User getUser(Integer id);
    public void deleteUser(Integer id);
    public List<User> getUsers();
}