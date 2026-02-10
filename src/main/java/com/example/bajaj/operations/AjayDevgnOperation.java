package com.example.bajaj.operations;

import com.example.bajaj.engine.CastingDirector;
import com.example.bajaj.engine.CommandResolver;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class AjayDevgnOperation extends CastingDirector {

    public AjayDevgnOperation(CommandResolver universe) {
        super(universe);
    }

    @Override
    protected String role() {
        return "lcm";
    }

    @Override
    public Object execute(Object input) {

        JsonNode arr = (JsonNode) input;

        long singham = arr.get(0).asLong();

        for (int i = 1; i < arr.size(); i++)
            singham = lcm(singham, arr.get(i).asLong());

        return singham;
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
