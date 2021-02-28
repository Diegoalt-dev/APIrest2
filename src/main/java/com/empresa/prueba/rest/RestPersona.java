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
    public String guardar(@RequestBody RecPersona persona2){
        if(tokenService.validaToken(persona2.getToken())) {
            Persona2 persona = new Persona2(persona2.getId(),persona2.getNombre(), persona2.getApellidos());
            personaDao.save(persona);
            return "Persona agregada";
        }
        else
        {
            return "Error en Token";
        }


    }
    @GetMapping("/listar")
    public List<Persona2> listar(@RequestBody RecToken token){
        if(tokenService.validaToken(token.getToken())) {
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
    public void borrar2(@PathVariable("id") Integer id){
        personaDao.deleteById(id);
    }

    @PutMapping("/actualizar")
    public String actualizar(@RequestBody RecPersona persona2){
        if(tokenService.validaToken(persona2.getToken())) {
            Persona2 persona = new Persona2(persona2.getId(),persona2.getNombre(), persona2.getApellidos());
            personaDao.save(persona);
            return "Persona agregada";
        }
        else
        {
            return "Error en Token";
        }
    }

    }


