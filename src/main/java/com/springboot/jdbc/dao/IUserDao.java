package com.springboot.jdbc.dao;

import java.util.List;

import com.springboot.jdbc.entity.User;

public interface IUserDao {
	public List<User> getAllUsers();
    
    public User getUser(String id);
    
    public void addUser(User userRecord);
    
    public void delete(String id);

}
