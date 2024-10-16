package org.example;

import org.example.dao.JDBC_Utils;
import org.example.dao.Session;
import org.example.dao.UsuarioDAO;
import org.example.models.Usuario;

import javax.swing.*;


/**
 * Clase JFrame que representa graficamente la ventana de login donde el usuario se registra
 */
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
                UsuarioDAO ud = new UsuarioDAO(JDBC_Utils.getConn());
                Usuario userIntroducido = ud.validateUser(user, password);

                if (userIntroducido != null) {
                    Session.id_usuario = userIntroducido.getId();
                    Session.usuario = userIntroducido;

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
