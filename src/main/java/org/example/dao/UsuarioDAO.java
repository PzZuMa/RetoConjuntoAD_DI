package org.example.dao;

import org.example.models.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que implementa la interfaz DAO y se encarga de manejar los usuarios en la base de datos
 */
public class UsuarioDAO implements DAO<Usuario>{
    @Override
    public ArrayList<Usuario> findAll() {
        ArrayList<Usuario> resultado = new ArrayList<>();

        try {
            var st = JDBC_Utils.getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Usuario");

            while (rs.next()){
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setNombre_usuario(rs.getString("nombre"));
                user.setContrasena(rs.getString("contraseña"));

                resultado.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    @Override
    public Usuario findByID(Integer id) {
        Usuario user = new Usuario();

        try {
            var st = JDBC_Utils.getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Usuario WHERE id = " + id);

            while (rs.next()){
                user.setId(rs.getInt("id"));
                user.setNombre_usuario(rs.getString("nombre"));
                user.setContrasena(rs.getString("contraseña"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void insert(Usuario user) {
        String sql = "INSERT INTO Usuario (nombre, contraseña) VALUES (?, ?)";
        try (PreparedStatement ps = JDBC_Utils.getConn().prepareStatement(sql)) {
            ps.setString(1, user.getNombre_usuario());
            ps.setString(2, user.getContrasena());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByID(Integer id) {
        String sql = "DELETE FROM Usuario WHERE id = ?";
        try (PreparedStatement ps = JDBC_Utils.getConn().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que busca en la base de datos los nombres de usuario y su respectiva contraseña
     * @return HashMap con los nombres de usuario y sus contraseñas
     */
    public HashMap<String, String> findUserPass (){
        var resultado = new HashMap<String, String>();

        try {
            var st1 = JDBC_Utils.getConn().createStatement();
            ResultSet rsUP = st1.executeQuery("SELECT * FROM Usuario");

            while (rsUP.next()){
                String nombre = rsUP.getString("nombre");
                String pass = rsUP.getString("contraseña");
                resultado.put(nombre, pass);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return resultado;
    }

    /**
     * Método que busca el id de un usuario por su nombre
     * @param nombre Nombre del usuario
     * @return Id del usuario
     */
    public Integer findIdByName(String nombre){
        Integer id = null;

        try {
            var st2 = JDBC_Utils.getConn().createStatement();
            ResultSet rsID = st2.executeQuery("SELECT id FROM Usuario WHERE nombre LIKE '" + nombre + "'");

            while (rsID.next()){
                id = rsID.getInt("id");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return id;
    }

}
