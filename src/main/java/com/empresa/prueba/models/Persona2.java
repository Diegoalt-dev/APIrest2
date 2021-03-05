package com.empresa.prueba.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Persona2 {
    @Id

    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private Long cedula;
    @Column
    @Temporal(TemporalType.DATE)
    private java.util.Date fecha_nacimiento;
    @Column
    @Temporal(TemporalType.DATE)
    private java.util.Date fecha_expedicion;


    @OneToMany(mappedBy = "persona2")
    private List<Tarjeta> tarjeta;

    public Persona2() {
    }

    public Persona2(Integer id, String nombre, String apellidos, Long cedula, java.util.Date fecha_nacimiento, java.util.Date fecha_expedicion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_expedicion = fecha_expedicion;
    }

    public Integer getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public java.util.Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(java.util.Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public java.util.Date getFecha_expedicion() {
        return fecha_expedicion;
    }

    public void setFecha_expedicion(java.util.Date fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }
}
