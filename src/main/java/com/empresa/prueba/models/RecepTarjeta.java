package com.empresa.prueba.models;

import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class RecepTarjeta {
    private int id;
    private String banco;
    private int numero;
    private java.util.Date fecha_vencimiento;
    private int cvv;
    private int tarjetaPersona;

    public RecepTarjeta() {
    }

    public RecepTarjeta(int id, String banco, int numero, java.util.Date fecha_vencimiento, int cvv, int tarjetaPersona) {
        this.id = id;
        this.banco = banco;
        this.numero = numero;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cvv = cvv;
        this.tarjetaPersona = tarjetaPersona;
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

    public java.util.Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(java.util.Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getTarjetaPersona() {
        return tarjetaPersona;
    }

    public void setTarjetaPersona(int tarjetaPersona) {
        this.tarjetaPersona = tarjetaPersona;
    }
}
