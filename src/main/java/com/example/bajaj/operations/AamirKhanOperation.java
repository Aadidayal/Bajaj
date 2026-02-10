package com.example.bajaj.operations;

import com.example.bajaj.engine.CastingDirector;
       import com.example.bajaj.engine.CommandResolver;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AamirKhanOperation extends CastingDirector {

    public AamirKhanOperation(CommandResolver universe){
        super(universe);
    }

    @Override
    protected String role() {
        return "prime";
    }

    @Override
    public Object execute(Object input) {

        List<Integer> perfectionist = new ArrayList<>();

        for(JsonNode node : (JsonNode) input){
            int candidate = node.asInt();
            if(isPrime(candidate)) perfectionist.add(candidate);
        }

        return perfectionist;
    }

    private boolean isPrime(int salman){
        if(salman < 2) return false;
        for(int i=2;i*i<=salman;i++)
            if(salman%i==0) return false;
        return true;
    }
}
