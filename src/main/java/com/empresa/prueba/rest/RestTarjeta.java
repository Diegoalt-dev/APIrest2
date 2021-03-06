package com.empresa.prueba.rest;


import com.empresa.prueba.dao.PersonaDao;
import com.empresa.prueba.dao.TarjetaDao;

import com.empresa.prueba.models.RecepTarjeta;
import com.empresa.prueba.models.Tarjeta;
import com.empresa.prueba.services.PersonaService;
import com.empresa.prueba.services.TarjetaService;
import com.empresa.prueba.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
    @Autowired
    private RecepTarjeta recepTarjeta;




    //Métodos HTTP - Solicitud al servidor
    @PostMapping("/crear")
    public String guardar(@RequestHeader("Authorization") String token, @RequestBody RecepTarjeta tarjeta) {
        if(tokenService.validaToken(token)) {

            Tarjeta tarjeta2 = new Tarjeta(tarjeta.getId(),tarjeta.getBanco(),tarjeta.getNumero(),tarjeta.getFecha_vencimiento(), tarjeta.getCvv(), personaDao.findById(tarjeta.getTarjetaPersona()));



            if(tarjetaService.validaTarjeta(tarjeta2)){
                throw new RuntimeException("La tarjeta ya existe");
            }
            else
            {
                if (personaDao.findById(tarjeta.getTarjetaPersona()) != null) {
                    tarjetaDao.save(tarjeta2);
                    return "Tarjeta agregada";
                }
                else
                {
                    throw new RuntimeException("La persona no existe");
                }
            }
        }
        else
        {
            throw new RuntimeException("Error en Token");
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
    public String actualizar(@RequestHeader("Authorization") String token, @RequestBody RecepTarjeta tarjeta) {
        if (tokenService.validaToken(token)) {


            Tarjeta tarjeta2 = new Tarjeta(tarjeta.getId(), tarjeta.getBanco(), tarjeta.getNumero(), tarjeta.getFecha_vencimiento(), tarjeta.getCvv(), personaDao.findById(tarjeta.getTarjetaPersona()));

            if (tarjetaService.validaTarjeta(tarjeta2)) {
                if (personaDao.findById(tarjeta.getTarjetaPersona()) != null) {
                    tarjetaDao.save(tarjeta2);
                    return "Tarjeta Actualizada";
                } else {
                    return "Persona no existe";
                }

            } else {
                return "Tarjeta no existe";
            }
        } else {
            return "Error en Token";
        }
    }

}
