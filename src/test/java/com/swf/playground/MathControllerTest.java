package com.swf.playground;

import com.swf.playground.controller.MathController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
class MathControllerTest {

	@Autowired
	MockMvc mvc;

	@Test
	public void testGetMathExists() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/math").accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void testGetCalculateAdd() throws Exception {
		String expected = "1 + 2 = 3";
		RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=add&x=1&y=2")
				.accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testGetCalculateSubtract() throws Exception {
		String expected = "2 - 1 = 1";
		RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=subtract&x=2&y=1")
				.accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testGetCalculateMultiply() throws Exception {
		String expected = "3 * 2 = 6";
		RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=3&y=2")
				.accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testGetCalculateDivide() throws Exception {
		String expected = "30 / 5 = 6";
		RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x=30&y=5")
				.accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testGetCalculateAddByDefault() throws Exception {
		String expected = "30 + 5 = 35";
		RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?x=30&y=5").accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testPostCalculateSumMultipleOperands() throws Exception {
		String expected = "4 + 5 + 6 = 15";
		RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=4&n=5&n=6").accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testPostCalculateSumMultipleOperandsAndExtraParameters() throws Exception {
		String expected = "4 + 5 + 6 = 15";
		RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=4&n=5&n=6&x=7&y=99")
				.accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testPostVolumeWithLengthWidthHeight() throws Exception {
		// POST /math/volume/3/4/5 should render the result The volume of a 3x4x5
		// rectangle is 60

		String expected = "The volume of a 3x4x5 rectangle is 60";
		RequestBuilder request = MockMvcRequestBuilders.post("/math/volume/3/4/5").accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testPatchVolumeWithLengthWidthHeight() throws Exception {
		// PATCH /math/volume/6/7/8 should render the result The volume of a 6x7x8
		// rectangle is 336

		String expected = "The volume of a 6x7x8 rectangle is 336";
		RequestBuilder request = MockMvcRequestBuilders.patch("/math/volume/6/7/8").accept(MediaType.TEXT_PLAIN);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testPostMathAreaCircleWithRadius() throws Exception {
		String expected = "Area of a circle with a radius of 4 is 50.26548";
		RequestBuilder request = MockMvcRequestBuilders.post("/math/area/").param("type", "circle").param("radius", "4")
				.accept(MediaType.APPLICATION_FORM_URLENCODED);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testPostMathAreaRectangleWithHeightWidth() throws Exception {
		String expected = "Area of a 4x7 rectangle is 28";
		RequestBuilder request = MockMvcRequestBuilders.post("/math/area/").param("type", "rectangle")
				.param("width", "4").param("height", "7").accept(MediaType.APPLICATION_FORM_URLENCODED);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

	@Test
	public void testPostMathAreaRectangleInvalid() throws Exception {
		String expected = "Invalid";
		RequestBuilder request = MockMvcRequestBuilders.post("/math/area/").param("type", "rectangle")
				.param("radius", "5").accept(MediaType.APPLICATION_FORM_URLENCODED);
		this.mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(expected));
	}

}