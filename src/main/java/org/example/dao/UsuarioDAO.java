package org.example.dao;

import org.example.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario> {
    Connection con;

    /**
     * Crea el DAO con la conexion
     * @param c conexion para inciarlo
     */
    public UsuarioDAO(Connection c) {
        con=c;
    }

    @Override
    public List<Usuario> findAll() {
        return List.of();
    }

    /**
     * Metodo para encotrar un usuario por su id
     * @param id id del usuario
     * @return usuario con id igual al pasado
     */
    @Override
    public Usuario findById(Integer id) {
        Usuario ret = null;
        try(PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios where id = ?")) {
            ps.setInt(1, id);
            var result = ps.executeQuery();
            if(result.next()){
                ret = new Usuario(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    @Override
    public void save(Usuario usuario) {

    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void delete(Usuario usuario) {

    }

    /**
     * Metodo para encontrar un usuario segun su nombre de usuario
     * @param usuario nombre de usuario
     * @return Usuario con el nombre pasado por parametro
     */
    public Usuario findByUsuario(String usuario) {
        Usuario ret = null;
        try(PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios where usuario = ?")) {
            ps.setString(1, usuario);
            var result = ps.executeQuery();
            if(result.next()){
                ret = new Usuario(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }
}
