package org.example.dao;

import org.example.Session;
import org.example.models.Copia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CopiaDAO implements DAO<Copia> {

    @Override
    public ArrayList<Copia> findAll() {
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
    public Copia findByID(Integer id) {
        Copia copia = new Copia();

        try {
            var st = JDBC_Utils.getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Copia WHERE id = " + id);

            while (rs.next()){
                copia.setId(rs.getInt("id"));
                copia.setId_pelicula(rs.getInt("id_pelicula"));
                copia.setId_usuario(rs.getInt("id_usuario"));
                copia.setEstado(rs.getString("estado"));
                copia.setSoporte(rs.getString("soporte"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return copia;
    }

    @Override
    public void insert(Copia copy) {
        String sql = "INSERT INTO Copia (id_pelicula, id_usuario, estado, soporte) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = JDBC_Utils.getConn().prepareStatement(sql)) {
            ps.setInt(1, copy.getId_pelicula());
            ps.setInt(2, copy.getId_usuario());
            ps.setString(3, copy.getEstado());
            ps.setString(4, copy.getSoporte());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByID(Integer id) {
        String sql = "DELETE FROM Copia WHERE id = ?";
        try (PreparedStatement ps = JDBC_Utils.getConn().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Copia> findPelisByUser(Integer id) {
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

}
