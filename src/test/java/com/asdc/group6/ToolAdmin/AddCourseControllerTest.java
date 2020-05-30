package com.asdc.group6.ToolAdmin;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.asdc.group6.Group6Application;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { Group6Application.class,
		AddCourseController.class })
@AutoConfigureMockMvc
public class AddCourseControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAddCourseControllerView() throws Exception {
		this.mockMvc.perform(get("/addCourseView")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Add Course Panel")));
	}
}