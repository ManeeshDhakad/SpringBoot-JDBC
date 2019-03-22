package com.springboot.jpa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.jdbc.JdbcApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=JdbcApplication.class)
public class JdbcApplicationTests {

	@Autowired
	private com.springboot.jdbc.service.UserService userService;
	
	@Test
	public void testGetUser() throws JsonProcessingException{	
		//Fetching the Book details directly from the DB to verify the API succeeded
		com.springboot.jdbc.entity.User user = userService.getUser("1");
		assertEquals("Maneesh", user.getName());
		assertEquals("maneesh@gmail.com", user.getEmail());
	}
}
