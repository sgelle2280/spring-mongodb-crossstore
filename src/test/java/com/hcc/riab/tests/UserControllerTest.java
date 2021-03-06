package com.hcc.riab.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcc.riab.UserController;

/**
 * 
 * @author sgelle
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{ "file:src/main/webapp/WEB-INF/rest-context.xml",
		   "file:src/main/webapp/WEB-INF/spring-servlet.xml",
		   "file:src/main/resources/applicationContext.xml"
		})
public class UserControllerTest {
	private MockMvc mockMvc;
	@Autowired
	UserController userController;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testPersistenceStatus() throws Exception {
		mockMvc.perform(post("/rest/users/records"))
		.andExpect(status().isOk());      
	}
}
