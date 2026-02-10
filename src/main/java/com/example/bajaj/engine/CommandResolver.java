package com.example.bajaj.engine;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
@Component
public class CommandResolver {

    private final Map<String, Operation> cinemaUniverse = new HashMap<>();

    public void register(String key, Operation actor){
        cinemaUniverse.put(key, actor);
    }

    public Operation resolve(String key){
        return cinemaUniverse.get(key);
    }
}