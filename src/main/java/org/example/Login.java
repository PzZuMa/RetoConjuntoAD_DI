package org.example;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Login extends JFrame {

    private JPanel login;
    private JButton loginButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public static Integer id_usuario;

    public Login(){
        this.setTitle("Login");
        this.setContentPane(login);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);
        this.setResizable(false);


        loginButton.addActionListener(e -> {
            String user = textField1.getText();
            String password = new String(passwordField1.getPassword());

            HashMap<String, String> usuariosPWD = new HashMap<>();

            // Sacamos los usuarios y contraseñas de la BD.
            try {
                var st1 = JDBC_Utils.getConn().createStatement();
                ResultSet rsUP = st1.executeQuery("SELECT * FROM Usuario");

                while (rsUP.next()){
                    String nombre = rsUP.getString("nombre");
                    String pass = rsUP.getString("contraseña");
                    usuariosPWD.put(nombre, pass);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            // Comprobamos si el usuario y la contraseña son correctos y están en la BD.
            if (usuariosPWD.containsKey(user) && usuariosPWD.containsValue(password)){

                // Sacamos el ID del usuario que ha iniciado sesión.
                try {
                    var st2 = JDBC_Utils.getConn().createStatement();
                    ResultSet rsID = st2.executeQuery("SELECT id FROM Usuario WHERE nombre LIKE '" + user + "'");

                    while (rsID.next()){
                        id_usuario = rsID.getInt("id");
                        System.out.println(id_usuario);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                // Accedemos a la ventana principal
                Principal principal = new Principal();
                principal.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
            }

        });


        cancelButton.addActionListener(e -> {
            System.exit(0);
        });
    }
}
