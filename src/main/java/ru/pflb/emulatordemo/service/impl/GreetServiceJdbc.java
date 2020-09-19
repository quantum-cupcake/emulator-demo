package ru.pflb.emulatordemo.service.impl;

import org.springframework.stereotype.Service;
import ru.pflb.emulatordemo.dao.GreetingsDao;
import ru.pflb.emulatordemo.service.GreetService;

@Service
public class GreetServiceJdbc implements GreetService {

    private final GreetingsDao greetingsDao;

    public GreetServiceJdbc(GreetingsDao greetingsDao) {
        this.greetingsDao = greetingsDao;
    }

    @Override
    public String getGreeting(Integer id) {
        return greetingsDao.getGreeting(id);
    }
}
