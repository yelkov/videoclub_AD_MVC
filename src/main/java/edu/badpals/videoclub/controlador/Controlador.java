package edu.badpals.videoclub.controlador;

import edu.badpals.videoclub.modelo.Modelo;
import edu.badpals.videoclub.modelo.Pelicula;
import edu.badpals.videoclub.vista.Peticiones;
import edu.badpals.videoclub.vista.Vista;

import java.util.List;

public class Controlador {
    Modelo modelo = new Modelo();
    Vista vista = new Vista();

    public void control(){
        modelo.conectarBD();
        vista.bienvenida();
        int respuesta = 0;
        while(respuesta != 4){
            respuesta = vista.mostrarMenu();
            switch (respuesta){
                case 1:
                    List<Pelicula> catalogo = modelo.selectPeliculas();
                    vista.mostrarPeliculas(catalogo);
                    break;
                case 2:
                    int idPelicula = Peticiones.pedirIdPelicula();
                    Pelicula pelicula = modelo.selectPelicula(idPelicula);
                    if(pelicula == null){
                        vista.mostrarMensaje("La película con id: "+ idPelicula + " no existe.");
                    }else{
                        int accion = 1;
                        while(accion == 1 || accion == 5){
                            accion = vista.mostrarMenuConsulta(pelicula);
                            consultar(accion,pelicula);
                        }
                    }
                    break;
                case 3:
                    Pelicula nuevaPelicula = Peticiones.pedirCreacion();
                    boolean valido = false;
                    while(!valido){
                        String confirmacion = Peticiones.pedirConfirmacion("creación");
                        if(confirmacion.equals("s") || confirmacion.equals("si") || confirmacion.equals("sí") || confirmacion.isEmpty()){
                            modelo.insertPelicula(nuevaPelicula);
                            vista.mostrarMensaje("Película creada.");
                            valido = true;
                        }else if(confirmacion.equals("n") || confirmacion.equals("no")){
                            vista.mostrarMensaje("Proceso abortado. Película no creada.");
                            valido = true;
                        }else{
                            vista.mostrarMensaje("Opción no válida. Seleccione 's' o 'n'.");
                        }
                    }
                    break;
                case 4:
                    vista.despedida();
                    break;
                case 5:
                    vista.mostrarMensaje("Opción no encontrada");
                    break;
            }
        }
        modelo.desconectarBD();
    }

    private void consultar(int accion, Pelicula pelicula){
        boolean valido;
        switch (accion){
            case 1:
                vista.mostrarDetallesPelicula(pelicula);
                break;
            case 2:
                Peticiones.pedirActualizaciones(pelicula);
                valido = false;
                while(!valido){
                    String confirmacion = Peticiones.pedirConfirmacion("actualización");
                    if(confirmacion.equals("s") || confirmacion.equals("si") || confirmacion.equals("sí") || confirmacion.isEmpty()){
                        modelo.updatePelicula(pelicula);
                        vista.mostrarMensaje("Película actualizada.");
                        valido = true;
                    }else if(confirmacion.equals("n") || confirmacion.equals("no")){
                        vista.mostrarMensaje("Proceso abortado. Volviendo a menú principal");
                        valido = true;
                    }else{
                        vista.mostrarMensaje("Opción no válida. Seleccione 's' o 'n'.");
                    }
                }
                break;
            case 3:
                valido = false;
                while(!valido){
                    String confirmacion = Peticiones.pedirConfirmacion("eliminación");
                    if(confirmacion.equals("s") || confirmacion.equals("si") || confirmacion.equals("sí") || confirmacion.isEmpty()){
                        modelo.deletePelicula(pelicula);
                        vista.mostrarMensaje("Película eliminada.");
                        valido = true;
                    }else if(confirmacion.equals("n") || confirmacion.equals("no")){
                        vista.mostrarMensaje("Proceso abortado. Volviendo a menú principal");
                        valido = true;
                    }else{
                        vista.mostrarMensaje("Opción no válida. Seleccione 's' o 'n'.");
                    }
                }
                break;
            case 4:
                vista.mostrarMensaje("Volviendo a menú principal.");
                break;
            case 5:
                vista.mostrarMensaje("Opción no encontrada.");
                break;
        }
    }
}
