package org.practice.mvc;

import org.practice.entities.BlogEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jitendra on 7/30/16.
 */

@Controller
public class MyController {

    @RequestMapping("/test")
//    public ResponseEntity<Object> test() {
//        BlogEntry blogEntry = new BlogEntry();
//        blogEntry.setTitle("Test Blog Entry");
//        return new ResponseEntity<Object>(blogEntry, HttpStatus.OK);
//    }

    public @ResponseBody BlogEntry test1() {
        System.out.println("Inside GET");
        BlogEntry blogEntry = new BlogEntry();
        blogEntry.setTitle("New Test Blog Entry");
        return blogEntry;
    }

    @RequestMapping(value="/test", method = RequestMethod.POST)
    public @ResponseBody BlogEntry test2( @RequestBody BlogEntry blogEntry) {
        System.out.println("Inside POST");
        return blogEntry;
    }


}
