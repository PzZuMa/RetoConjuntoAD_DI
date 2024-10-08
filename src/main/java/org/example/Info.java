package org.example;

import javax.swing.*;
import java.awt.event.*;

public class Info extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel titulo;

    public Info() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        pack();



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
