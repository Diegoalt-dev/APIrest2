package com.empresa.prueba.services;

import com.empresa.prueba.dao.PersonaDao;
import com.empresa.prueba.models.Persona2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    @Autowired
    private PersonaDao personaDao;

    public boolean validaPersona(Persona2 persona2){
        if (personaDao.findById(persona2.getId())!=null){
            return true;
        }
        else
        {
            return false;
        }
    }
}


