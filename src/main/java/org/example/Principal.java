package org.example;

import org.example.dao.CopiaDAO;
import org.example.dao.JDBC_Utils;
import org.example.models.Copia;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.util.ArrayList;

public class Principal extends JFrame {

    private JPanel principal;
    private JButton salirButton;
    private JList list1;
    private JButton cerrarButton;
    private JPanel botones;

    private DefaultListModel listModel = new DefaultListModel<Copia>();

    public Principal() {
        this.setTitle("Principal");
        this.setContentPane(principal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);
        this.setResizable(false);

        CopiaDAO cd = new CopiaDAO();
        var listaJuegos = new ArrayList<Copia>();
        if (Session.id_usuario == 0) {
            listaJuegos = cd.findAll();
        } else {
            listaJuegos = cd.findPelisByUser(Session.id_usuario);
        }

        listModel.addAll(listaJuegos);
        list1.setModel(listModel);

        list1.getSelectionModel().addListSelectionListener(
                (ListSelectionEvent e) -> {
                    if (e.getValueIsAdjusting()){
                        return;
                    } else {
                        Session.copia_seleccionada = (Copia) listModel.getElementAt(list1.getSelectedIndex());
                        var details = new Info();
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
