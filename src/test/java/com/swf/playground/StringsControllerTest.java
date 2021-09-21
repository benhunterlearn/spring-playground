package com.swf.playground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(StringsController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StringsControllerTest {

	// @Autowired
	@MockBean
	WordCounter wordCounter;

	@Autowired
	MockMvc mockMvc;

	// @Test
	// public void testStringsControllerExists() {
	// assertNotNull(this.stringsController);
	// }

	@BeforeEach
	public void setup() {
		Map<String, Integer> expected = new HashMap<>();
		expected.put("one", 2);
		expected.put("two", 1);

		when(wordCounter.count("one two one")).thenReturn(expected);
	}

	@Test
	public void postWordCountReturnsJSONWithWordCount() throws Exception {
		String message = "one two one";
		RequestBuilder request = MockMvcRequestBuilders.post("/word/count").content(message);

		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json("{\"one\":2,\"two\":1}"));
	}

}
