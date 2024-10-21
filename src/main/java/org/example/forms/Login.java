package org.example.forms;

import org.example.dao.JdbcUtils;
import org.example.dao.UsuarioDAO;
import org.example.Sesion;
import org.example.models.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Login extends JFrame{
    private JPanel panel1;
    private JButton cerrarButton;
    private JButton iniciarSesionButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel error;

    public Login(){
        cerrarButton.addActionListener((ActionEvent e)->{
            dispose();
        });
        iniciarSesionButton.addActionListener((ActionEvent e)->{
            Usuario u = autenticar(textField1.getText(), passwordField1.getText());
            if (u != null){
                dispose();
                Sesion.usuario = u;
                var v = new Principal();
                v.setSize(600,400);
                v.setVisible(true);
            }else{
                error.setText("ERROR: Usuario o contraseña incorrectos");
            }

        });
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestor Peliculas");
        setLocationRelativeTo(null);
    }

    /**
     * Metodo para autenticar que el usuario y contraseña coinciden con uno de la base de datos
     * @param usuario nombre de usuario
     * @param contrasena contraseña del usuario
     * @return duvuelve null si no coinciden ambas claves con alguno en la base de datos
     */
    private Usuario autenticar(String usuario, String contrasena){
        UsuarioDAO usuarioDAO = new UsuarioDAO(JdbcUtils.getCon());
        Usuario u = usuarioDAO.findByUsuario(usuario);
        if(!(u != null && u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena))){
            u = null;
        }
        return u;
    }
}
