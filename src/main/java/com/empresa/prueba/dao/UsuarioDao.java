package com.empresa.prueba.dao;

import com.empresa.prueba.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDao extends JpaRepository<Usuarios,String> {
    Optional<Usuarios> findByUser(String user);
}
