package com.empresa.prueba.rest;

import com.empresa.prueba.dao.TokenDao;
import com.empresa.prueba.dao.UsuarioDao;
import com.empresa.prueba.models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
