package com.demo;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.beans.User;
import com.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppTest.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;

	@Test
	public void testCreate() throws Exception {

		User user = new User();
		user.setId(1);
		user.setPassword("dsf");
		user.setStatus("df");
		user.setUsername("fdsf");

		given(userService.add(user)).willReturn(user);
		mvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=").content(asJsonString(user)))
				.andExpect(status().isOk());
	}
	
	@Test
    public void testGetUser() throws Exception {
		
		User user = new User();
		user.setId(1);
		user.setPassword("dsf");
		user.setStatus("df");
		user.setUsername("fdsf");

		given(userService.findById(1)).willReturn(user);
		
        mvc.perform(get("/user?id=1").header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=").accept(MediaType.APPLICATION_JSON))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
       // .toString();
    }
	
	@Test
	public void updateEmployeeAPI() throws Exception
	{
		User user = new User();
		user.setId(1);
		user.setPassword("dsf");
		user.setStatus("df");
		user.setUsername("fdsf");

		given(userService.add(user)).willReturn(user);
		
	  mvc.perform( MockMvcRequestBuilders
	      .put("/user")
	      .content(asJsonString(user))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON).header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ="))
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.content().string(String.valueOf(1)));
	}
	
	@Test
	public void deleteUser() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .delete("/user?id=1")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON).header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ="))
	      .andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
