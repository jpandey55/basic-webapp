package org.practice.rest.mvc;


import org.practice.core.entities.BlogEntry;
import org.practice.core.services.BlogEntryService;
import org.practice.rest.resources.BlogEntryResource;
import org.practice.rest.resources.asm.BlogEntryResourceAsm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by jitendra on 7/30/16.
 */

@Controller
public class BlogEntryController {

//1    @RequestMapping("/test")
//    public ResponseEntity<Object> test() {
//        BlogEntry blogEntry = new BlogEntry();
//        blogEntry.setTitle("Test Blog Entry");
//        return new ResponseEntity<Object>(blogEntry, HttpStatus.OK);
//    }
//
//2    @RequestMapping("/test")
//    public @ResponseBody
//    BlogEntry test1() {
//        System.out.println("Inside GET");
//        BlogEntry blogEntry = new BlogEntry();
//        blogEntry.setTitle("New Test Blog Entry");
//        return blogEntry;
//    }
//
//    @RequestMapping(value="/test", method = RequestMethod.POST)
//    public @ResponseBody BlogEntry test2( @RequestBody BlogEntry blogEntry) {
//        System.out.println("Inside POST");
//        return blogEntry;
//    }


    private BlogEntryService service;

    public BlogEntryController(BlogEntryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/rest/blog-entries/{blogEntryId}", method = RequestMethod.GET)
    public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long blogEntryId) {
        BlogEntry entry = service.find(blogEntryId);
        if (entry != null) {
            BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);
            return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
        }
    }
}
