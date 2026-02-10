package com.example.bajaj.guard;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class InputSanitizer {

    public String validate(JsonNode body) {

        if (body == null || body.size() == 0)
            return "Empty request";

        Iterator<String> keys = body.fieldNames();

        if (!keys.hasNext())
            return "No operation provided";

        String key = keys.next();

        if (keys.hasNext())
            return "Only one operation allowed";

        JsonNode value = body.get(key);

        switch (key) {

            case "fibonacci":
                if (!value.isInt() || value.asInt() < 0)
                    return "Invalid fibonacci input";
                break;

            case "prime":
            case "lcm":
            case "hcf":
                if (!value.isArray() || value.size() == 0)
                    return "Array required";
                break;

            case "AI":
                if (!value.isTextual())
                    return "Question must be string";
                break;

            default:
                return "Unsupported operation";
        }

        return null; // valid
    }
}
