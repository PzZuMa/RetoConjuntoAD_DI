package org.example;

import org.example.dao.JDBC_Utils;
import org.example.dao.PeliculaDAO;
import org.example.dao.Session;
import org.example.models.Pelicula;
import javax.swing.*;

/**
 * Clase JDialog que muestra la informacion de la pelicula seleccionada
 */
public class Info extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField tfTitulo;
    private JTextField tfGenero;
    private JTextField tfAnho;
    private JTextField tfDescripcion;
    private JTextField tfDirector;
    private JButton actualizarButton;
    private JLabel soporte;
    private JLabel estado;

    public Info() {
        this.setContentPane(contentPane);
        this.setModal(true);
        this.getRootPane().setDefaultButton(buttonOK);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 400);

        PeliculaDAO pd = new PeliculaDAO(JDBC_Utils.getConn());
        Pelicula og = pd.findByID(Session.copia_seleccionada.getId_pelicula());

        this.setTitle("Info de "+og.getTitulo());

        tfTitulo.setText(og.getTitulo());
        tfGenero.setText(og.getGenero());
        tfAnho.setText(String.valueOf(og.getAnio()));
        tfDescripcion.setText(og.getDescripcion());
        tfDirector.setText(og.getDirector());
        estado.setText(Session.copia_seleccionada.getEstado());
        soporte.setText(Session.copia_seleccionada.getSoporte());

        buttonOK.addActionListener( e -> {
            dispose();
        });

        actualizarButton.addActionListener( e -> {
            Pelicula peliUpdated = new Pelicula();
            peliUpdated.setTitulo(tfTitulo.getText());
            peliUpdated.setGenero(tfGenero.getText());
            peliUpdated.setAnio(Integer.parseInt(tfAnho.getText()));
            peliUpdated.setDescripcion(tfDescripcion.getText());
            peliUpdated.setDirector(tfDirector.getText());
            peliUpdated.setId(og.getId());
            pd.update(peliUpdated);

            JOptionPane.showMessageDialog(this, "Pelicula actualizada correctamente.");
        });
    }
}
