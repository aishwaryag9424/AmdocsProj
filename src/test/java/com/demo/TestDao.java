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
import com.demo.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppTest.class)
public class TestDao {

	@Autowired
	UserDao userDao;

	@Before
	public void createContext() {
		User user = new User();
		user.setPassword("dsf");
		user.setStatus("df");
		user.setUsername("fdsf");
		userDao.add(user);
	}

	@Test
	public void testGetById() {
		User user = userDao.findById(1);
		assertNotNull(user);
		assertEquals(1, user.getId());
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setPassword("sadas");
		user.setStatus("df");
		user.setUsername("fdsf");

		User userCreated = userDao.add(user);
		assertEquals("sadas", userCreated.getPassword());
	}

	@Test
	public void createUser() {
		User user = new User();
		user.setPassword("dsf");
		user.setStatus("df");
		user.setUsername("fdsf");

		User userCreated = userDao.add(user);
		assertNotNull(userCreated);
	}

	@Test
	public void testGetByIdFail() {
		User user = userDao.findById(2);
		assertNull(user);
	}

	@Test
	public void testUpdateFail() {
		User user = new User();
		user.setPassword("sadas");
		user.setStatus("df");
		user.setUsername("fdsf");

		User userCreated = userDao.add(user);
		assertNotEquals("sadas1", userCreated.getPassword());
	}
}
