package com.example.bajaj.HealthGateway;
import com.example.bajaj.engine.CommandResolver;
import com.example.bajaj.model.BajajEnvelope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HealthGateway {

    @GetMapping("/health")
    public BajajEnvelope alive(){
        return new BajajEnvelope(true,
                "aadi.be23@chitkara.edu.in",
                null);
    }
}