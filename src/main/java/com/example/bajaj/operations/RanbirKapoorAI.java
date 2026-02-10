package com.example.bajaj.operations;

import com.example.bajaj.ai.GeminiClient;
import com.example.bajaj.engine.CastingDirector;
import com.example.bajaj.engine.CommandResolver;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class RanbirKapoorAI extends CastingDirector {

    private final GeminiClient aliaBhatt;

    public RanbirKapoorAI(CommandResolver universe, GeminiClient aliaBhatt) {
        super(universe);
        this.aliaBhatt = aliaBhatt;
    }

    @Override
    protected String role() {
        return "AI";
    }

    @Override
    public Object execute(Object input) {
        String question = ((JsonNode) input).asText();
        return aliaBhatt.ask(question);
    }
}
