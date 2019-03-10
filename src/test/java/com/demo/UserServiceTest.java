package com.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.beans.User;
import com.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AppTest.class)
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Before
	public void createContext() {
		User user = new User();
		user.setPassword("dsf");
		user.setStatus("df");
		user.setUsername("fdsf");
		
		userService.add(user);
	}
	
	@Test
	public void testGetById() {
		User user = userService.findById(1);
		assertNotNull(user);
	}
	
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(1);
		user.setPassword("dev1");
		user.setStatus("df");
		user.setUsername("fdsf");
		
		User userCreated = userService.add(user);
		assertEquals("dev1", userCreated.getPassword());
	}
	@Test
	public void createUser() {
		User user = new User();
		user.setPassword("dsf");
		user.setStatus("df");
		user.setUsername("fdsf");
		
		User userCreated = userService.add(user);
		assertNotNull(userCreated);
	}
	@Test
	public void testGetByIdFail() {
		User user = userService.findById(2);
		assertNull(user);
	}
	@Test
	public void testUpdateFail() {
		User user = new User();
		user.setPassword("sd");
		user.setStatus("df");
		user.setUsername("fdsf");
		
		User userCreated = userService.add(user);
		assertNotEquals("sd1", userCreated.getPassword()); 
	}
	
}
