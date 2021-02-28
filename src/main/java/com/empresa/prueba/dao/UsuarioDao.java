package com.empresa.prueba.dao;

import com.empresa.prueba.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuarios,String> {
    public abstract Usuarios findByUser(String user);
}
