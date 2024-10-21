package org.example.dao;

import org.example.models.Copia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CopiaDAO implements DAO<Copia> {
    Connection con;

    /**
     * Crea el DAO con la conexion
     * @param c conexion para inciarlo
     */
    public CopiaDAO(Connection c) {
        con=c;
    }

    @Override
    public List<Copia> findAll() {
        return List.of();
    }

    @Override
    public Copia findById(Integer id) {
        return null;
    }

    @Override
    public void save(Copia copia) {

    }

    @Override
    public void update(Copia copia) {

    }

    @Override
    public void delete(Copia copia) {

    }

    /**
     * Devuelve una lista con todas las copias pertenecientes al usuario pasado por parametro
     * @param idUsuario id del usuario del cual buscar las copias
     * @return Lista con todas las copias
     */
    public List<Copia> findAllByUsuario(Integer idUsuario) {
        ArrayList<Copia> ret = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement("SELECT * FROM copias where id_usuario = ?")) {
            ps.setInt(1, idUsuario);
            var result = ps.executeQuery();
            while(result.next()){
                Copia aux = new Copia(
                        result.getInt(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getString(4),
                        result.getString(5)
                );
                ret.add(aux);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }
}
