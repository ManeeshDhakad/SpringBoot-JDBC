package com.springboot.jdbc.service;

import java.util.List;

import com.springboot.jdbc.entity.User;

public interface IUserService {
	
	public List<User> getAllUsers();
    
    public User getUser(String id);
    
    public void addUser(User userRecord);
    
    public void delete(String id);
}
