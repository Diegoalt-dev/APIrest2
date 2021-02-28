package com.empresa.prueba.dao;


import com.empresa.prueba.models.Usuarios;
import com.empresa.prueba.models.Usuariotoken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDao extends JpaRepository<Usuariotoken,Integer> {
    public abstract Usuariotoken findByToken(String token);
    public abstract Usuariotoken findByUsuarioUser(String user);
}
