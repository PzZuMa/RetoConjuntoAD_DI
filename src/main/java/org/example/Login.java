package org.example;

import org.example.dao.UsuarioDAO;
import javax.swing.*;
import java.util.HashMap;

public class Login extends JFrame {

    private JPanel login;
    private JButton loginButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JPasswordField passwordField1;


    public Login(){
        this.setTitle("Login");
        this.setContentPane(login);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);
        this.setResizable(false);

        loginButton.addActionListener(e -> {
            var user = textField1.getText();
            var password = new String(passwordField1.getPassword());

            if (user.equals("admin") && password.equals("admin")){
                Session.id_usuario = 0;
                Principal principal = new Principal();
                principal.setVisible(true);
                this.setVisible(false);
            } else {
                var mapaUsers = new HashMap<String, String >();
                var ud = new UsuarioDAO();

                // Sacamos los usuarios y contraseñas de la BD.
                mapaUsers = ud.findUserPass();

                // Comprobamos si el usuario y la contraseña son correctos y están en la BD.
                if (mapaUsers.containsKey(user) && mapaUsers.containsValue(password)){

                    // Sacamos el ID del usuario que ha iniciado sesión.
                    Session.id_usuario = ud.findIdByName(user);

                    // Accedemos a la ventana principal
                    Principal principal = new Principal();
                    principal.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
                }
            }


        });

        cancelButton.addActionListener(e -> {
            System.exit(0);
        });
    }
}
