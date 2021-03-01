package com.empresa.prueba.dao;


import com.empresa.prueba.models.Persona2;
import com.empresa.prueba.models.Usuariotoken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona2,Integer> {
    public abstract Persona2 findById(int id);
}
