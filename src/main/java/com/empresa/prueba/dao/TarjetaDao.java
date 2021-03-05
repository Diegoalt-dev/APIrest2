package com.empresa.prueba.dao;


import com.empresa.prueba.models.Persona2;
import com.empresa.prueba.models.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaDao extends JpaRepository<Tarjeta,Integer> {
    public abstract Tarjeta findById(int id);

}
