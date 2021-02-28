package com.empresa.prueba.models;

import javax.persistence.*;

@Entity
public class Usuariotoken {
    @Id
    @Column
    private int Id;

    @Column
    private String token;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usuariotoken_user", referencedColumnName = "user")
    private Usuarios usuario;


    public int getId() {
        return Id;
    }


    public Usuarios getUser() {
        return usuario;
    }

    public void setUser(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
