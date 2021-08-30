package com.jeon.springxml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicContoller {
    
    @RequestMapping("/basic")
    @ResponseBody
    public String basic() {
        return "basic controller";
    }
}
