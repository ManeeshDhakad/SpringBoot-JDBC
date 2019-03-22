package com.springboot.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jdbc.dao.UserDoa;
import com.springboot.jdbc.entity.User;  

@Service  
public class UserService implements IUserService{  
    @Autowired  
    UserDoa userDao;
    
    @Override
    public List<User> getAllUsers(){  
        List<User>userRecords = userDao.getAllUsers();
        return userRecords;  
    }  
    
    @Override
    public User getUser(String id){  
        return userDao.getUser(id);  
    }  
    
    @Override
    public void addUser(User user){  
    	userDao.addUser(user);  
    } 
    
    @Override
    public void delete(String id){  
    	userDao.delete(id);  
    }  
}  