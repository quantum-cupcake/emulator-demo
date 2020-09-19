package ru.pflb.emulatordemo.dao.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.pflb.emulatordemo.dao.GreetingsDao;

import java.sql.ResultSet;
import java.util.Map;

@Repository
public class GreetingsDaoJdbc implements GreetingsDao {

    private final NamedParameterJdbcOperations jdbc;

    public GreetingsDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public String getGreeting(Integer id) {
        return jdbc.query("select message from test_schema.test_table tt where id = :id",
                Map.of("id", id),
                (ResultSet rS) -> {
                    rS.next();
                    return rS.getString("message");
                });
    }

}
