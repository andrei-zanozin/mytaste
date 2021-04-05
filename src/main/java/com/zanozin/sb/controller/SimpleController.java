package com.zanozin.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

    @GetMapping("/simple")
    @ResponseBody
    public String getSimpleString() {
        return "This is simple string.";
    }

}
