package org.example.models;

import lombok.Data;

@Data
public class Copia {
    private int id;
    private int id_pelicula;
    private int id_usuario;
    private String estado;
    private String soporte;

    public Copia(int id, int id_pelicula, int id_usuario, String estado, String soporte) {
        this.id = id;
        this.id_pelicula = id_pelicula;
        this.id_usuario = id_usuario;
        this.estado = estado;
        this.soporte = soporte;
    }
}
