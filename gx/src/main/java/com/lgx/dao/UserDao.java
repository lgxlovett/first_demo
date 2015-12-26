package com.lgx.dao;

import com.lgx.model.User;

public interface UserDao {
    
    public void addUser(User user);
    
    public void updateUser(User user);
    
    public User findUserByName(String name);
    
    public User findUserById(String id);
    
    public void deleteUser(String id);
}
