package com.empresa.prueba.models;


import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Tarjeta {
    @Id
    private int id;
    @Column
    private String banco;
    @Column
    private int numero;
    @Column
    @Temporal(TemporalType.DATE)
    private Calendar fecha_vencimiento;
    @Column
    private int cvv;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tarjeta_persona", referencedColumnName = "id")
    private Persona2 persona2;

    public Tarjeta() {
    }

    public Tarjeta(int id, String banco, int numero, Calendar fecha_vencimiento, int cvv, Persona2 persona2) {
        this.id = id;
        this.banco = banco;
        this.numero = numero;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cvv = cvv;
        this.persona2 = persona2;
    }

    public int getId() {
        return id;
    }


    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Calendar getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Calendar fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Persona2 getPersona2() {
        return persona2;
    }

    public void setPersona2(Persona2 persona2) {
        this.persona2 = persona2;
    }
}
