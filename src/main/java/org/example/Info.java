package org.example;

import org.example.dao.PeliculaDAO;
import org.example.models.Pelicula;
import javax.swing.*;

public class Info extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel titulo;
    private JLabel genero;
    private JLabel anho;
    private JLabel descripcion;
    private JLabel director;
    private JLabel estado;
    private JLabel soporte;

    public Info() {
        this.setContentPane(contentPane);
        this.setModal(true);
        this.getRootPane().setDefaultButton(buttonOK);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 400);

        PeliculaDAO pd = new PeliculaDAO();
        Pelicula og = pd.findByID(Session.copia_seleccionada.getId_pelicula());

        this.setTitle(og.getTitulo());

        titulo.setText("Titulo: "+og.getTitulo());
        genero.setText("Genero: "+og.getGenero());
        anho.setText("Año: "+og.getAnio());
        descripcion.setText("Descripcion: "+og.getDescripcion());
        director.setText("Director: "+og.getDirector());
        estado.setText("Estado: "+Session.copia_seleccionada.getEstado());
        soporte.setText("Soporte: "+Session.copia_seleccionada.getSoporte());

        buttonOK.addActionListener( e -> {
            dispose();
        });
    }
}
