package com.empresa.prueba.rest;


import com.empresa.prueba.dao.PersonaDao;
import com.empresa.prueba.dao.TarjetaDao;
import com.empresa.prueba.models.Persona2;

import com.empresa.prueba.models.Tarjeta;
import com.empresa.prueba.services.PersonaService;
import com.empresa.prueba.services.TarjetaService;
import com.empresa.prueba.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("tarjeta")
public class RestTarjeta {
    @Autowired
    private PersonaDao personaDao; //Inyeccion de dependencia
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PersonaService personaService;
    @Autowired
    private TarjetaDao tarjetaDao;
    @Autowired
    private TarjetaService tarjetaService;


    //Métodos HTTP - Solicitud al servidor
    @PostMapping("/crear")
    public String guardar(@RequestHeader("Authorization") String token, @RequestBody Tarjeta tarjeta){
        if(tokenService.validaToken(token)) {
            if(tarjetaService.validaTarjeta(tarjeta)){
                return "Tarjeta ya existente";
            }
            else
            {
                tarjetaDao.save(tarjeta);
                return "Tarjeta agregada";
            }

        }
        else
        {
            return "Error en Token";
        }


    }
    @GetMapping("/listar")
    public List<Tarjeta> listar(@RequestHeader("Authorization") String token){
        if(tokenService.validaToken(token)) {
            return tarjetaDao.findAll();
        }
        else
        {
            return Collections.<Tarjeta>emptyList();
        }
    }




    @DeleteMapping("/borrar2/{id}")
    public void borrar2(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id){
        tarjetaDao.deleteById(id);
    }

    @PutMapping("/actualizar")
    public String actualizar(@RequestHeader("Authorization") String token, @RequestBody Tarjeta tarjeta){
        if(tokenService.validaToken(token)) {

            if(tarjetaService.validaTarjeta(tarjeta)){
                tarjetaDao.save(tarjeta);
                return "Tarjeta actualizada";
            }
            else {
                return "La Tarjeta no existe";
            }

        }
        else
        {
            return "Error en Token";
        }
    }

}
