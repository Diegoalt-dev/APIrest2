package com.empresa.prueba.rest;


import com.empresa.prueba.dao.PersonaDao;
import com.empresa.prueba.models.Persona2;
import com.empresa.prueba.recep_models.RecPersona;
import com.empresa.prueba.recep_models.RecToken;
import com.empresa.prueba.recep_models.Recborrado;
import com.empresa.prueba.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
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


    //Métodos HTTP - Solicitud al servidor
    @PostMapping("/crear")
    public String guardar(@RequestHeader("Authorization") String token, @RequestBody Persona2 persona){
        if(tokenService.validaToken(token)) {

            personaDao.save(persona);
            return "Persona agregada";
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
    @DeleteMapping("/borrar")
    public String borrar(@RequestBody Recborrado borrado){
        if(tokenService.validaToken(borrado.getToken())) {
            personaDao.deleteById(borrado.getId());
            return "Se realizó el borrado";
        }
        else
        {
            return "Token inválido";
        }


    }
    @DeleteMapping("/borrar2/{id}")
    public void borrar2(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id){
        personaDao.deleteById(id);
    }

    @PutMapping("/actualizar")
    public String actualizar(@RequestHeader("Authorization") String token, @RequestBody Persona2 persona){
        if(tokenService.validaToken(token)) {

            personaDao.save(persona);
            return "Persona agregada";
        }
        else
        {
            return "Error en Token";
        }
    }

    }


