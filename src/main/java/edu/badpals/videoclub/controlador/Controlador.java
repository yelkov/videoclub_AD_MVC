package edu.badpals.videoclub.controlador;

import edu.badpals.videoclub.modelo.Modelo;
import edu.badpals.videoclub.modelo.Pelicula;
import edu.badpals.videoclub.vista.Vista;

import java.util.List;

public class Controlador {
    Modelo modelo = new Modelo();
    Vista vista = new Vista();

    public void control(){
        modelo.conectarBD();
        vista.bienvenida();
        int respuesta = 0;
        while(respuesta != 5){
            respuesta = vista.mostrarMenu();
            switch (respuesta){
                case 1:
                    List<Pelicula> catalogo = modelo.selectPeliculas();
                    vista.mostrarPeliculas(catalogo);
                    break;
                case 5:
                    vista.despedida();
                    break;
                case 6:
                    vista.mostrarMensajeError("Opción no encontrada");
                    break;
            }
        }
    }
}
