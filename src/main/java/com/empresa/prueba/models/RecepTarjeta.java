package com.empresa.prueba.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Calendar;


public class RecepTarjeta {
    private int id;
    private String banco;
    private int numero;
    private Calendar fecha_vencimiento;
    private int cvv;
    private int tarjeta_persona;

    public RecepTarjeta() {
    }

    public RecepTarjeta(int id, String banco, int numero, Calendar fecha_vencimiento, int cvv, int tarjeta_persona) {
        this.id = id;
        this.banco = banco;
        this.numero = numero;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cvv = cvv;
        this.tarjeta_persona = tarjeta_persona;
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

    public int getTarjeta_persona() {
        return tarjeta_persona;
    }

    public void setTarjeta_persona(int tarjeta_persona) {
        this.tarjeta_persona = tarjeta_persona;
    }
}
