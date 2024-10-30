package com.openapi.openconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api")
public class HelloworldController {
  @GetMapping("/hello")
  @ResponseBody
  public String helloWorld() {
    return "Hello";
  }
}
