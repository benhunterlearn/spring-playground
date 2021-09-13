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
@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testHelloPage() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_PLAIN);  // .contentType() also available
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello friend."));
    }

    @Test
    public void testIndexAcceptsQueryString() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/?one=1&two=2"))
                .andExpect(status().isOk());
    }

    @Test
    public void testPathVariables() throws Exception {
        int driverId = 3;
        this.mvc.perform(MockMvcRequestBuilders.get(String.format("/drivers/%d/trips", driverId)))
                .andExpect(status().isOk())
                .andExpect(content().string("3"));
    }

    @Test
    public void testMathPi() throws Exception{
        String expected = String.valueOf(Math.PI);
        
        this.mvc.perform(MockMvcRequestBuilders.get("/math/pi"))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));

    }
}