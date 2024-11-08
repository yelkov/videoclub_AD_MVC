package edu.badpals.videoclub.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
    private static final String URL = "jdbc:mysql://localhost:3306/peliculas";
    private static final String USER = "root";
    private static final String PASS = "root";
    public static Connection connection = null;
    private static Statement statement = null;

    public void conectarBD(){
        try{
            if(connection == null){
                connection = DriverManager.getConnection(URL,USER,PASS);
            }
            if(statement == null){
                statement = connection.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar la BD");
            e.printStackTrace();
        }
    }

    public void desconectarBD(){
        if(statement != null){
            try{
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar statement");
                e.printStackTrace();
            }finally{
                statement = null;
            }
        }
        if(connection != null){
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar connection");
                e.printStackTrace();
            }finally{
                connection = null;
            }
        }
    }

    public List<Pelicula> selectPeliculas(){
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try(ResultSet rs = statement.executeQuery("select * from peliculas")){
            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String actor = rs.getString("actor");
                Tematica tematica = Tematica.asignarTematica(rs.getString("tematica"));
                String guion = rs.getString("guion");
                boolean disponible = rs.getBoolean("disponible");
                Pelicula pelicula = new Pelicula(id,titulo, actor, tematica, guion, disponible);
                peliculas.add(pelicula);
            }
            return peliculas;
        }catch (SQLException e){
            System.out.println("Error al leer los datos de todas las películas.");
            e.printStackTrace();
        }
        return null;
    }

    public Pelicula selectPelicula(int id){
        try{
            PreparedStatement ps = connection.prepareStatement("select * from peliculas where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String titulo = rs.getString("titulo");
                String actor = rs.getString("actor");
                String guion = rs.getString("guion");
                Tematica tematica = Tematica.asignarTematica(rs.getString("tematica"));
                boolean disponible = rs.getBoolean("disponible");
                Pelicula pelicula = new Pelicula(id,titulo, actor, tematica, guion, disponible);
                ps.close();
                return pelicula;
            }
        }catch (SQLException e){
            System.out.println("Error al leer los datos de la película de id " + id +".");
            e.printStackTrace();
        }
        return null;
    }

    public void updatePelicula(Pelicula pelicula){
        try{
            PreparedStatement ps = connection.prepareStatement("update peliculas set titulo = ?, actor = ?, tematica = ?, guion = ?, disponible = ?  where id = ?");
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2,pelicula.getProtagonista());
            ps.setString(3, pelicula.getTematica().getNombre());
            ps.setString(4,pelicula.getDescripcion());
            ps.setBoolean(5,pelicula.isDisponible());
            ps.setInt(6,pelicula.getId());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            System.out.println("Error al actualizar los datos de la película.");
            e.printStackTrace();
        }
    }

    public void deletePelicula(Pelicula pelicula){
        try{
            PreparedStatement ps = connection.prepareStatement("delete from peliculas where id = ?");
            ps.setInt(1, pelicula.getId());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            System.out.println("Error al eliminar los datos de la película.");
            e.printStackTrace();
        }
    }

    public void insertPelicula(Pelicula pelicula){
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT into peliculas(TITULO, ACTOR, TEMATICA, GUION, DISPONIBLE) VALUES(?,?,?,?,?)");
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2,pelicula.getProtagonista());
            ps.setString(3, pelicula.getTematica().getNombre());
            ps.setString(4, pelicula.getDescripcion());
            ps.setBoolean(5, pelicula.isDisponible());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            System.out.println("Error al guardar película en la BD.");
            e.printStackTrace();
        }
    }
}
