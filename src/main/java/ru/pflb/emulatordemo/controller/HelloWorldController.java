package ru.pflb.emulatordemo.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pflb.emulatordemo.service.GreetService;

@RestController
@RequestMapping("/api/emulator")
public class HelloWorldController {

    private final GreetService greetService;

    public HelloWorldController(@Qualifier("greetServiceJdbc") GreetService greetService) {
        this.greetService = greetService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/hello/{id}")
    public String helloById(@PathVariable Integer id) {
        return greetService.getGreeting(id);
    }
}
