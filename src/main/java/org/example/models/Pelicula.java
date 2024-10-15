package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa una pelicula
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {
    private Integer id;
    private String titulo;
    private String genero;
    private Integer anio;
    private String descripcion;
    private String director;

    @Override
    public String toString() {
        return "Nombre: "+ titulo +
                ", Genero: " + genero +
                ", Estreno: " + anio +
                ", Descripcion: " + descripcion  +
                ", Director: " + director;
    }
}
