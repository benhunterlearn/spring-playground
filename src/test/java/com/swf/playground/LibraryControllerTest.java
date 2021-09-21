package com.swf.playground;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LibraryController.class)
class LibraryControllerTest {

	@Autowired
	MockMvc mvc;

	@Test
	public void testBookSearch() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/library/search").accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void testBookSearchWithTitleAndISBN() throws Exception {
		String expected = "BookSearch{author='null', ISBN='00001', title='Example'}";
		RequestBuilder request = MockMvcRequestBuilders.get("/library/search?title=Example&ISBN=00001");

		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testStringRaw() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/library/string-raw")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).param("one", "1").param("two", "2");

		this.mvc.perform(request).andExpect(status().isOk());
	}

	@Test
	@Ignore
	public void testStringMap() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/library/string-map")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				// .param("one", "1")
				// .param("two", "2")
				.content("one=1&two=2");

		this.mvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void testStringPojo() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/library/string-pojo")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).param("one", "1").param("two", "2");

		this.mvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void testStringPojoQueryString() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/library/string-pojo?one=1")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).param("two", "2");

		this.mvc.perform(request).andExpect(status().isOk());
	}

}