package org.example.models;

import lombok.Data;

@Data
public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private int ano;
    private String descripcion;
    private String director;

    public Pelicula(int id, String titulo, String genero, int ano, String descripcion, String director) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.descripcion = descripcion;
        this.director = director;
    }
}
