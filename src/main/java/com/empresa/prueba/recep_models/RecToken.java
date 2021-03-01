package com.empresa.prueba.recep_models;

import org.springframework.stereotype.Component;

@Component
public class RecToken {
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public RecToken(String token) {
        this.token = token;
    }

    public RecToken() {
    }
}
