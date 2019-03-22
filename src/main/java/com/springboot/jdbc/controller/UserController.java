package com.springboot.jdbc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jdbc.entity.User;
import com.springboot.jdbc.service.UserService; 

@RestController  
public class UserController {  
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired  
    private UserService userService;
    
    @RequestMapping("/")  
    public List<User> getAllUser(){  
    	logger.info("Getting user information : " + "getAllUser()");
        return userService.getAllUsers();  
    }     
    
    @RequestMapping(value="/add-user", method=RequestMethod.POST)  
    public String addUser(@RequestBody User userRecord){  
    	logger.info("Adding new user information : " + "addUser()");
        userService.addUser(userRecord);  
        return "User data inserted successfully";
    }  
    
    @RequestMapping(value="/get-user/{id}", method=RequestMethod.GET)  
    public User getUser(@PathVariable String id){  
        return userService.getUser(id);  
    }  
    
    @RequestMapping(value="/delete-user/{id}", method=RequestMethod.GET)  
    public String deleteUser(@PathVariable String id){  
        userService.delete(id);  
        return "User data deleted successfully";
    }
}  