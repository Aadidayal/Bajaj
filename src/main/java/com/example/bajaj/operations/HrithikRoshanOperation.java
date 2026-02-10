package com.example.bajaj.operations;

import com.example.bajaj.engine.CastingDirector;
import com.example.bajaj.engine.CommandResolver;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HrithikRoshanOperation extends CastingDirector {

    public HrithikRoshanOperation(CommandResolver universe) {
        super(universe);
    }

    @Override
    protected String role() {
        return "fibonacci";
    }

    @Override
    public Object execute(Object input) {

        int n = ((JsonNode) input).asInt();

        if (n < 0) return "Number must be non-negative";

        List<Integer> danceSteps = new ArrayList<>();

        int shah = 0, ranveer = 1;

        for (int i = 0; i < n; i++) {
            danceSteps.add(shah);
            int next = shah + ranveer;
            shah = ranveer;
            ranveer = next;
        }

        return danceSteps;
    }
}
