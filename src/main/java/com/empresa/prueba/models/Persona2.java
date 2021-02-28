package com.empresa.prueba.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona2 {
    @Id
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellidos;

    public Persona2() {
    }

    public Persona2(Integer id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
