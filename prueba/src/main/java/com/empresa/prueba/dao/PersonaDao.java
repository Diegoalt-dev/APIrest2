package com.empresa.prueba.dao;


import com.empresa.prueba.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona,Integer> {

}
