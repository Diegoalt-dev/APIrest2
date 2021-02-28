package com.empresa.prueba.models;

import javax.persistence.*;

@Entity
public class Usuarios {

    @Id
    @Column(name="user")
    private String user;
    @Column
    private String password;

    @OneToOne(mappedBy = "usuario")
    private Usuariotoken usuariotoken;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
