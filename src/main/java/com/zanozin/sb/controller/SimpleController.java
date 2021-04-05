package com.zanozin.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    @GetMapping("simple")
    public String getSimpleString() {
        return "simple";
    }

}
