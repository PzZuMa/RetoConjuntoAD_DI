package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Clase que representa un usuario
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Integer id;
    private String nombre_usuario;
    private String contrasena;
}
