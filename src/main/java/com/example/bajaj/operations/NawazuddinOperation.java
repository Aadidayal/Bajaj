package com.example.bajaj.operations;

import com.example.bajaj.engine.CastingDirector;
import com.example.bajaj.engine.CommandResolver;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class NawazuddinOperation extends CastingDirector {

    public NawazuddinOperation(CommandResolver universe) {
        super(universe);
    }

    @Override
    protected String role() {
        return "hcf";
    }

    @Override
    public Object execute(Object input) {

        JsonNode arr = (JsonNode) input;

        int sacredGames = arr.get(0).asInt();

        for (int i = 1; i < arr.size(); i++)
            sacredGames = gcd(sacredGames, arr.get(i).asInt());

        return sacredGames;
    }

    private int gcd(int rao, int nawaz) {
        return nawaz == 0 ? rao : gcd(nawaz, rao % nawaz);
    }
}
