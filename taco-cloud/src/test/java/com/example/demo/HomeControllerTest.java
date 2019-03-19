package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import controller.HomeController;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testHomePage()  throws Exception{
		
		mockMvc.perform(get("/")) // pilla la raiz donde esta el homecontroller
		
		.andExpect(status().isOk()) // espera una respueta Http 200
		
		.andExpect(view().name("home")) // espera la vista de home
		
		.andExpect(content().string(containsString("Welcome to ..."))); // espera el contenido 
		
	}
	
}
