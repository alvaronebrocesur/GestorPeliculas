package org.example.forms;

import org.example.Sesion;
import org.example.dao.CopiaDAO;
import org.example.dao.JdbcUtils;
import org.example.dao.PeliculaDAO;
import org.example.models.Copia;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton cerrarButton;
    private JButton cerrarSesionButton;
    private DefaultTableModel model;

    public Principal() {
        model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Estado");
        model.addColumn("Soporte");
        table1.setModel(model);
        CopiaDAO copiaDAO = new CopiaDAO(JdbcUtils.getCon());
        PeliculaDAO peliculaDAO = new PeliculaDAO(JdbcUtils.getCon());
        for (Copia c : copiaDAO.findAllByUsuario(Sesion.usuario.getId())) {
            model.addRow(new Object[] {peliculaDAO.findById(c.getId_pelicula()).getTitulo(), c.getEstado(), c.getSoporte()});
        }
        cerrarButton.addActionListener((ActionEvent _)->{
            dispose();
        });
        cerrarSesionButton.addActionListener((ActionEvent _)-> {
            dispose();
            Sesion.usuario = null;
            var v = new Login();
            v.setSize(600,400);
            v.setVisible(true);
        });
        table1.getSelectionModel().addListSelectionListener((ListSelectionEvent _) -> {
            dispose();
            Sesion.pelicula = peliculaDAO.findByTitulo(model.getValueAt(table1.getSelectedRow(), 0).toString());
            Sesion.copia = copiaDAO.findAllByUsuario(Sesion.usuario.getId()).get(table1.getSelectedRow());
            var v = new Detalles();
            v.setSize(600,400);
            v.setVisible(true);
        });
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestor Peliculas");
        setLocationRelativeTo(null);
    }
}
