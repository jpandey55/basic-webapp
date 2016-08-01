package org.practice.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


/**
 * Created by Jitendra on 7/31/16.
 */


public class MyControllerTest {
    @InjectMocks
    private MyController myController;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this); //initializes fields annotated with Mockito annotations
        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
    }

    @Test
    public void test1() throws Exception {
        mockMvc.perform(get("/test")).andDo(print());
    }

    @Test
    public void test2() throws Exception {
        mockMvc.perform(post("/test").content("{\"title\":\"Test Blog Title\"}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is("Test Blog Title")))
                .andDo(print());
    }
}
