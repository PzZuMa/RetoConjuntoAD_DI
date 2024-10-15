package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dao.JDBC_Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Copia {
    private Integer id;
    private Integer id_pelicula;
    private Integer id_usuario;
    private String estado;
    private String soporte;

    @Override
    public String toString() {
        String tituloPelicula = null;

        try {
            var st = JDBC_Utils.getConn().createStatement();
            ResultSet rsUP = st.executeQuery(
                    "SELECT DISTINCT(Pelicula.titulo) " +
                    "FROM Pelicula " +
                    "INNER JOIN Copia ON Pelicula.id = Copia.id_pelicula " +
                    "WHERE Pelicula.id LIKE "+ id_pelicula + ";"
            );

            while (rsUP.next()){
                tituloPelicula = rsUP.getString("titulo");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return tituloPelicula + " - " + estado + " - " + soporte;
    }
}
