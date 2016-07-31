package org.practice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.springframework.test.web.servlet.MockMvc.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by jitendra on 7/31/16.
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
    public void test() throws Exception {
        mockMvc.perform(get("/test")).andDo(print());
    }
}
