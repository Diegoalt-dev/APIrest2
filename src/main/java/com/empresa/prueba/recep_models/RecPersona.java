package com.empresa.prueba.recep_models;

import com.empresa.prueba.models.Persona2;
import org.springframework.stereotype.Component;

@Component
public class RecPersona extends Persona2 {
    private String token;



    public String getToken() {
        return token;
    }
}
