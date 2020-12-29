package com.example.demo.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {
    private static final Logger logger
            = LoggerFactory.getLogger(Hello.class);
    public Hello(){
        logger.debug("Started app");
    }
    @GetMapping
    public String hello(){
        logger.info("Example log from {}", Hello.class.getSimpleName());
        return "Hello World";
    }

}
