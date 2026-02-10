package com.example.bajaj.gateway;

import com.example.bajaj.engine.CommandResolver;
import com.example.bajaj.engine.Operation;
import com.example.bajaj.guard.InputSanitizer;
import com.example.bajaj.model.BajajEnvelope;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.*;

@RestController
public class BFHLGateway {

    private final CommandResolver castingDirector;
    private final InputSanitizer bodyguard;

    private static final String MAIL = "aadi0256.be23@chitkara.edu.in";

    public BFHLGateway(CommandResolver castingDirector, InputSanitizer bodyguard) {
        this.castingDirector = castingDirector;
        this.bodyguard = bodyguard;
    }

    @PostMapping("/bfhl")
    public BajajEnvelope perform(@RequestBody(required = false) JsonNode body) {

        try {

            // ---- 1. validate request ----
            String problem = bodyguard.validate(body);
            if (problem != null)
                return new BajajEnvelope(false, MAIL, problem);

            // ---- 2. detect operation ----
            String key = body.fieldNames().next();
            JsonNode value = body.get(key);

            Operation hero = castingDirector.resolve(key);

            if (hero == null)
                return new BajajEnvelope(false, MAIL, "Unsupported operation");

            // ---- 3. execute operation ----
            Object result = hero.execute(value);

            return new BajajEnvelope(true, MAIL, result);

        } catch (Exception e) {
            return new BajajEnvelope(false, MAIL, "Invalid request format");
        }
    }
}
