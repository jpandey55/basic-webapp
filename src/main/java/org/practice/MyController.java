package org.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jitendra on 7/30/16.
 */

@Controller
public class MyController {

    @RequestMapping("/test")
    public String test() {
        return "view";
    }
}
