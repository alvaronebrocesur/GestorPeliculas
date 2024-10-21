package org.example.models;

import lombok.Data;

@Data
public class Usuario {
    private int id;
    private String usuario;
    private String contrasena;

    public Usuario(int id, String usuario, String contrasena) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}
