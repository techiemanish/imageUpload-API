package com.photoupload;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @GetMapping("/")
    public String healthCheck(){
        return "Photo Upload API is up and running V1.0";
    }
}
