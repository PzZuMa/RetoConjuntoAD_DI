package org.example.dao;

import org.example.models.Copia;
import org.example.models.Pelicula;
import org.example.models.Usuario;

/**
 * Clase para almacenar datos del usuario que ha iniciado sesion o la copia seleccionada.
 */
public class Session {
    public static Integer id_usuario;
    public static Usuario usuario;
    public static Pelicula pelicula_seleccionada;
    public static Copia copia_seleccionada;
}
