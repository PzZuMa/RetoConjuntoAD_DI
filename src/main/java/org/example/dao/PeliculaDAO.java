package org.example.dao;

import org.example.models.Pelicula;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeliculaDAO implements DAO<Pelicula> {

    @Override
    public ArrayList<Pelicula> findAll() {
        ArrayList<Pelicula> resultado = new ArrayList<>();

        try {
            var st = JDBC_Utils.getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Pelicula");

            while (rs.next()){
                Pelicula peli = new Pelicula();
                peli.setId(rs.getInt("id"));
                peli.setTitulo(rs.getString("titulo"));
                peli.setGenero(rs.getString("genero"));
                peli.setAnio(rs.getInt("año"));
                peli.setDescripcion(rs.getString("descripcion"));
                peli.setDirector(rs.getString("director"));

                resultado.add(peli);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    @Override
    public Pelicula findByID(Integer id) {
        Pelicula peli = new Pelicula();
        try {
            var st = JDBC_Utils.getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Pelicula WHERE id = " + id);

            while (rs.next()){
                peli.setId(rs.getInt("id"));
                peli.setTitulo(rs.getString("titulo"));
                peli.setGenero(rs.getString("genero"));
                peli.setAnio(rs.getInt("año"));
                peli.setDescripcion(rs.getString("descripcion"));
                peli.setDirector(rs.getString("director"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return peli;
    }

    @Override
    public void insert(Pelicula peli) {
        String sql = "INSERT INTO Pelicula (titulo, genero, año, descripcion, director) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = JDBC_Utils.getConn().prepareStatement(sql)) {
            ps.setString(1, peli.getTitulo());
            ps.setString(2, peli.getGenero());
            ps.setInt(3, peli.getAnio());
            ps.setString(4, peli.getDescripcion());
            ps.setString(5, peli.getDirector());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByID(Integer id) {
        String sql = "DELETE FROM Pelicula WHERE id = ?";
        try (PreparedStatement ps = JDBC_Utils.getConn().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
