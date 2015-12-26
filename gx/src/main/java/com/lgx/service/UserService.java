package com.lgx.service;

import com.lgx.model.User;
public interface UserService {
    
    public void addUser(User user);
    
    public void updateUser(User user);
    
    public User findUserByName(String name);
    
    public User findUserById(String id);
    
    public void deleteUser(String id);
}
