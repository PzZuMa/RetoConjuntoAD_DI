package org.example.dao;

import lombok.Getter;
import lombok.Setter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que se encarga de manejar la conexión con la base de datos
 */
public class JDBC_Utils {

    @Getter
    @Setter
    public static final Connection conn;

    static{
        String url = "jdbc:mysql://localhost:3306/ejercicioConjunto";
        String user = "root";
        String password = System.getenv("MYSQL_ROOT_PASSWORD");

        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos." +e.getMessage());
        }
    }
}
