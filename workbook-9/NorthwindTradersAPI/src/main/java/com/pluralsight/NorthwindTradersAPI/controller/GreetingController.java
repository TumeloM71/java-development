package com.pluralsight.NorthwindTradersAPI.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.pluralsight.NorthwindTradersAPI.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello,%s %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "country",defaultValue = "World") String country,
                             @RequestParam(value = "state") String state) {
        return new Greeting(counter.incrementAndGet(), String.format(template,state,country));
    }
}
