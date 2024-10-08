package org.example;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

public class Principal extends JFrame {

    private JPanel principal;
    private JButton salirButton;
    private JList list1;

    private DefaultListModel listModel = new DefaultListModel<String>();

    public Principal() {
        this.setTitle("Principal");
        this.setContentPane(principal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);
        this.setResizable(false);

        listModel.addElement("Pan");
        listModel.addElement("Leche");
        listModel.addElement("Huevos");
        listModel.addElement("Azucar");
        listModel.addElement("Sal");

        list1.setModel(listModel);

        list1.getSelectionModel().addListSelectionListener(
                (ListSelectionEvent e) -> {
                    if (e.getValueIsAdjusting()){
                        return;
                    } else {
                        System.out.println("Indice de dato seleccionado: " + list1.getSelectedIndex());
                        var title = listModel.getElementAt(list1.getSelectedIndex());

                        System.out.println(title);

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
    }
}
