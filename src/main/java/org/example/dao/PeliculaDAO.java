package org.example.dao;

import org.example.models.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PeliculaDAO implements DAO<Pelicula>{
    Connection con;

    /**
     * Crea el DAO con la conexion
     * @param c conexion para inciarlo
     */
    public PeliculaDAO(Connection c) {
        con=c;
    }

    @Override
    public List<Pelicula> findAll() {
        return List.of();
    }

    /**
     * Metodo para encotrar una pelicula por su id
     * @param id id de la pelicula
     * @return pelicula con id igual al pasado
     */
    @Override
    public Pelicula findById(Integer id) {
        Pelicula ret = null;
        try(PreparedStatement ps = con.prepareStatement("SELECT * FROM peliculas where id = ?")) {
            ps.setInt(1, id);
            var result = ps.executeQuery();
            if(result.next()){
                ret = new Pelicula(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(3),
                        result.getString(3)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    @Override
    public void save(Pelicula pelicula) {

    }

    @Override
    public void update(Pelicula pelicula) {

    }

    @Override
    public void delete(Pelicula pelicula) {

    }

    /**
     * Metodo para encontrar pelicula segun su titulo
     * @param titulo titulo de la pelicula
     * @return Pelicula con titulo igual al pasado por parametro
     */
    public Pelicula findByTitulo(String titulo) {
        Pelicula ret = null;
        try(PreparedStatement ps = con.prepareStatement("SELECT * FROM peliculas where titulo = ?")) {
            ps.setString(1, titulo);
            var result = ps.executeQuery();
            if(result.next()){
                ret = new Pelicula(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }
}
