package com.swf.playground;

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
@WebMvcTest(MathController.class)
class MathControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testGetMathExists() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math")
                .accept(MediaType.TEXT_PLAIN);
        this.mvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCalculateAdd() throws Exception {
        String expected = "1 + 2 = 3";
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=add&x=1&y=2")
                .accept(MediaType.TEXT_PLAIN);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void testGetCalculateSubtract() throws Exception {
        String expected = "2 - 1 = 1";
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=subtract&x=2&y=1")
                .accept(MediaType.TEXT_PLAIN);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void testGetCalculateMultiply() throws Exception {
        String expected = "3 * 2 = 6";
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=3&y=2")
                .accept(MediaType.TEXT_PLAIN);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void testGetCalculateDivide() throws Exception {
        String expected = "30 / 5 = 6";
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x=30&y=5")
                .accept(MediaType.TEXT_PLAIN);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }


    @Test
    public void testGetCalculateAddByDefault() throws Exception {
        String expected = "30 + 5 = 35";
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?x=30&y=5")
                .accept(MediaType.TEXT_PLAIN);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }


    @Test
    public void testPostCalculateSumMultipleOperands() throws Exception {
        String expected = "4 + 5 + 6 = 15";
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=4&n=5&n=6")
                .accept(MediaType.TEXT_PLAIN);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

}