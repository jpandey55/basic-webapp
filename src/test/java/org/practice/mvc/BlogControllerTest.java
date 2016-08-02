package org.practice.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.practice.core.entities.BlogEntry;
import org.practice.core.services.BlogEntryService;
import org.practice.rest.mvc.BlogEntryController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by Jitendra on 7/31/16.
 */


public class BlogControllerTest {
    @InjectMocks
    private BlogEntryController myController;
    private MockMvc mockMvc;

    @Mock
    private BlogEntryService service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this); //initializes fields annotated with Mockito annotations
        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
    }

//    @Test
//    public void test1() throws Exception {
//        mockMvc.perform(get("/test")).andDo(print());
//    }
//
//    @Test
//    public void test2() throws Exception {
//        mockMvc.perform(post("/test").content("{\"title\":\"Test Blog Title\"}").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.title", is("Test Blog Title")))
//                .andDo(print());
//    }

    @Test
    public void getExistingBlogEntry() throws Exception {
        BlogEntry entry = new BlogEntry();
        entry.setId(1L);
        entry.setTitle("Test Title");

        when(service.find(1L)).thenReturn(entry);

        mockMvc.perform(get("/rest/blog-entries/1"))
                .andDo(print())
                .andExpect(jsonPath("$.title", is(entry.getTitle())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void getNonExistingBlogEntry() throws Exception {

        when(service.find(1L)).thenReturn(null);

        mockMvc.perform(get("/rest/blog-entries/1"))
               .andExpect(status().isNotFound());
    }
}
