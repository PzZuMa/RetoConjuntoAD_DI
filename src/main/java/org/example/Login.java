package org.example;

import javax.swing.*;

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
            String user = textField1.getText();
            String password = new String(passwordField1.getPassword());
            if (user.equals("admin") && password.equals("admin")){
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
