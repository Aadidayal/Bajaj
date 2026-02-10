package com.example.bajaj.engine;

import jakarta.annotation.PostConstruct;


public abstract class CastingDirector implements Operation {

    protected final CommandResolver universe;

    public CastingDirector(CommandResolver universe) {
        this.universe = universe;
    }

    protected abstract String role();

    // auto registration when Spring creates bean
    @PostConstruct
    private void entryScene() {
        universe.register(role(), this);
    }
}
