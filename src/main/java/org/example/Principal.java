package org.example;

import org.example.dao.CopiaDAO;
import org.example.models.Copia;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Login.id_usuario;

public class Principal extends JFrame {

    private JPanel principal;
    private JButton salirButton;
    private JList list1;
    private JButton cerrarButton;

    private DefaultListModel listModel = new DefaultListModel<Copia>();

    public Principal() {
        this.setTitle("Principal");
        this.setContentPane(principal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);
        this.setResizable(false);

        CopiaDAO cd = new CopiaDAO();
        var listaJuegos = cd.findByID(id_usuario);

        listModel.addAll(listaJuegos);
        list1.setModel(listModel);

        list1.getSelectionModel().addListSelectionListener(
                (ListSelectionEvent e) -> {
                    if (e.getValueIsAdjusting()){
                        return;
                    } else {
                        System.out.println("Indice de dato seleccionado: " + list1.getSelectedIndex());
                        var title = (Copia) listModel.getElementAt(list1.getSelectedIndex());
                        System.out.println("Dato seleccionado: " + title);

                        var details = new Info(title);
                        details.setVisible(true);
                    }
                }
        );

        salirButton.addActionListener(e -> {
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        });

        cerrarButton.addActionListener(e -> {
            System.exit(0);
        });
    }
}
