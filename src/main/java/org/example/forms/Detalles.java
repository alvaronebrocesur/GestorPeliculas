package org.example.forms;

import org.example.Sesion;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Detalles extends JFrame {
    private JButton volverButton;
    private JLabel titulo;
    private JPanel panel1;
    private JLabel estado;
    private JLabel soporte;
    private JLabel ano;
    private JLabel genero;
    private JLabel director;
    private JTextArea descripcion;

    public Detalles() {
        descripcion.setText(Sesion.pelicula.getDescripcion());
        titulo.setText(Sesion.pelicula.getTitulo());
        estado.setText(Sesion.copia.getEstado());
        soporte.setText(Sesion.copia.getSoporte());
        ano.setText(String.valueOf(Sesion.pelicula.getAno()));
        genero.setText(Sesion.pelicula.getGenero());
        director.setText(Sesion.pelicula.getDirector());
        volverButton.addActionListener((ActionEvent e)->{
            dispose();
            Sesion.copia = null;
            Sesion.pelicula = null;
            var v = new Principal();
            v.setSize(600,400);
            v.setVisible(true);
        });
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setTitle("Gestor Peliculas");
        setLocationRelativeTo(null);
    }
}
