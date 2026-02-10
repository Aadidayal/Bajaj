package com.example.bajaj.model;

public class BajajEnvelope {

    private boolean is_success;
    private String official_email;
    private Object data;

    public BajajEnvelope(boolean success, String email, Object data){
        this.is_success = success;
        this.official_email = email;
        this.data = data;
    }

    public boolean isIs_success() {
        return is_success;
    }

    public String getOfficial_email() {
        return official_email;
    }

    public Object getData() {
        return data;
    }
}
