package org.example;

import org.example.dao.CopiaDAO;
import org.example.models.Copia;
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

    public Info(Copia title) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(1000, 400);

        CopiaDAO cd = new CopiaDAO();
        Pelicula og = cd.findPeliculaByID(title.getId_pelicula());

        setTitle(og.getTitulo());

        titulo.setText("Titulo: "+og.getTitulo());
        genero.setText("Genero: "+og.getGenero());
        anho.setText("Año: "+og.getAnio());
        descripcion.setText("Descripcion: "+og.getDescripcion());
        director.setText("Director: "+og.getDirector());
        estado.setText("Estado: "+title.getEstado());
        soporte.setText("Soporte: "+title.getSoporte());

        buttonOK.addActionListener( e -> {
            dispose();
        });
    }
}
