package com.empresa.prueba.rest;

import com.empresa.prueba.dao.TokenDao;
import com.empresa.prueba.dao.UsuarioDao;
import com.empresa.prueba.models.Persona2;
import com.empresa.prueba.models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("au")
public class RestAuth {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private TokenDao tokenDao;


    @PostMapping("/autenticar")
    public String autenticar(@RequestBody Usuarios usuarios) {
        System.out.println("****************************Encontró usuario?***********************************");
        Usuarios valorUser = usuarioDao.findByUser(usuarios.getUser());

        if (valorUser != null) {
            if (usuarios.getPassword().equals(valorUser.getPassword())) {

                return "Token: " + tokenDao.findByUsuarioUser(usuarios.getUser()).getToken();
            } else {
                return "Contraseña incorrecta";
            }
        } else {
            return "Usuario no existente";
        }
    }
    @GetMapping("/listarus")
    public List<Usuarios> listar(){

            return usuarioDao.findAll();

    }

}
