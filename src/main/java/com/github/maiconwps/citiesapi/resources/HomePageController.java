package com.github.maiconwps.citiesapi.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
    @GetMapping("/")
    public static String show_hell_word(){
        return "Hello Word";
    }
}
