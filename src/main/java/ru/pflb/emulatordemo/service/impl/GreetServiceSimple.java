package ru.pflb.emulatordemo.service.impl;

import org.springframework.stereotype.Service;
import ru.pflb.emulatordemo.service.GreetService;

import java.util.Map;

@Service
public class GreetServiceSimple implements GreetService {

    private final Map<Integer, String> greetings;

    public GreetServiceSimple() {
        this.greetings = Map.of(
                1, "hello",
                2, "goodbye"
        );
    }

    @Override
    public String getGreeting(Integer id) {
        return greetings.getOrDefault(id, "notFound");
    }
}
