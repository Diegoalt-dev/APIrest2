package com.empresa.prueba.rest;


import com.empresa.prueba.dao.PersonaDao;
import com.empresa.prueba.models.Persona2;

import com.empresa.prueba.services.PersonaService;
import com.empresa.prueba.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("personas")
public class RestPersona {
    @Autowired
    private PersonaDao personaDao; //Inyeccion de dependencia
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PersonaService personaService;


    //Métodos HTTP - Solicitud al servidor
    @PostMapping("/crear")
    public String guardar(@RequestHeader("Authorization") String token, @RequestBody Persona2 persona){
        if(tokenService.validaToken(token)) {

            if (personaDao.findById(persona.getId()).isEmpty()){
                personaDao.save(persona);
                return "Persona agregada";
            }
            else{
                return "Persona ya existe";
            }

        }
        else
        {
            return "Error en Token";
        }


    }
    @GetMapping("/listar")
    public List<Persona2> listar(@RequestHeader("Authorization") String token){
        if(tokenService.validaToken(token)) {
            return personaDao.findAll();
        }
        else
        {
            return Collections.<Persona2>emptyList();
        }
    }




    @DeleteMapping("/borrar2/{id}")
    public void borrar2(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id){
        personaDao.deleteById(id);
    }

    @PutMapping("/actualizar")
    public String actualizar(@RequestHeader("Authorization") String token, @RequestBody Persona2 persona) {
        if(tokenService.validaToken(token)) {

            if(!personaDao.findById(persona.getId()).isEmpty()) {

                personaDao.save(persona);
                return "Persona actualizada";
            }
            else{
                return "La persona no existe";
            }

        }
        else
        {
            return "Error en Token";
        }
    }

    }


