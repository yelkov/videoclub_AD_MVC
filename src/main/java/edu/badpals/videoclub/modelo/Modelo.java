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
                String titulo = rs.getString("titulo");
                String actor = rs.getString("actor");
                Tematica tematica = Tematica.asignarTematica(rs.getString("tematica"));
                String guion = rs.getString("guion");
                boolean disponible = rs.getBoolean("disponible");
                Pelicula pelicula = new Pelicula(titulo, actor, tematica, guion, disponible);
                peliculas.add(pelicula);
            }
            return peliculas;
        }catch (SQLException e){
            System.out.println("Error al leer los datos de todas las películas.");
            e.printStackTrace();
        }
        return null;
    }
}
