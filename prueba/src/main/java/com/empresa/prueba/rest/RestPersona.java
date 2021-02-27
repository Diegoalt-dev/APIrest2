package com.empresa.prueba.rest;

import com.empresa.prueba.dao.PersonaDao;
import com.empresa.prueba.models.Persona2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personas")
public class RestPersona {
    @Autowired
    private PersonaDao personaDao; //Inyeccion de dependencia

    //Métodos HTTP - Solicitud al servidor
    @PostMapping("/crear")
    public void guardar(@RequestBody Persona2 persona2){
        personaDao.save(persona2);
    }

    @GetMapping("/listar")
    public List<Persona2> listar(){
        return personaDao.findAll();
    }
    @DeleteMapping("/borrar")
    public void borrar(@RequestBody Integer id){
        personaDao.deleteById(id);
    }
    @DeleteMapping("/borrar2/{id}")
    public void borrar2(@PathVariable("id") Integer id){
        personaDao.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Persona2 persona2){
        personaDao.save(persona2);
    }

}
