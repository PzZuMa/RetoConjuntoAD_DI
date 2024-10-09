package org.example.dao;

import org.example.JDBC_Utils;
import org.example.models.Copia;
import org.example.models.Pelicula;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CopiaDAO implements DAO{

    @Override
    public List<Copia> findAll() {
        ArrayList<Copia> resultado = new ArrayList<>();

        try {
            var st = JDBC_Utils.getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Copia");

            while (rs.next()){
                Copia copia = new Copia();
                copia.setId(rs.getInt("id"));
                copia.setId_pelicula(rs.getInt("id_pelicula"));
                copia.setId_usuario(rs.getInt("id_usuario"));
                copia.setEstado(rs.getString("estado"));
                copia.setSoporte(rs.getString("soporte"));

                resultado.add(copia);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return resultado;
    }

    @Override
    public List<Copia> findByID(Integer id) {
        ArrayList<Copia> resultado = new ArrayList<>();

        try {
            var st = JDBC_Utils.getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Copia WHERE id_usuario = " + id);

            while (rs.next()){
                Copia copia = new Copia();
                copia.setId(rs.getInt("id"));
                copia.setId_pelicula(rs.getInt("id_pelicula"));
                copia.setId_usuario(rs.getInt("id_usuario"));
                copia.setEstado(rs.getString("estado"));
                copia.setSoporte(rs.getString("soporte"));

                resultado.add(copia);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public Pelicula findPeliculaByID(Integer id) {
        Pelicula resultado = new Pelicula();

        try {
            var st = JDBC_Utils.getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Pelicula WHERE id = " + id);

            while (rs.next()){
                resultado.setId(rs.getInt("id"));
                resultado.setTitulo(rs.getString("titulo"));
                resultado.setGenero(rs.getString("genero"));
                resultado.setAnio(rs.getInt("año"));
                resultado.setDescripcion(rs.getString("descripcion"));
                resultado.setDirector(rs.getString("director"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
}
