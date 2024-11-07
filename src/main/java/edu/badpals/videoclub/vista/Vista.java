package edu.badpals.videoclub.vista;

import edu.badpals.videoclub.modelo.Pelicula;

import java.util.List;

public class Vista {
    public void bienvenida(){
        System.out.println("\n" +
                "╔══════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║    ██╗   ██╗ ██╗ ██████╗  ███████╗  ██████╗   ██████╗ ██╗      ██╗   ██╗ ██████╗     ║\n" +
                "║    ██║   ██║ ██║ ██╔══██╗ ██╔════╝ ██╔═══██╗ ██╔════╝ ██║      ██║   ██║ ██╔══██╗    ║\n" +
                "║    ██║   ██║ ██║ ██║  ██║ █████╗   ██║   ██║ ██║      ██║      ██║   ██║ ██████╔╝    ║\n" +
                "║    ╚██╗ ██╔╝ ██║ ██║  ██║ ██╔══╝   ██║   ██║ ██║      ██║      ██║   ██║ ██╔══██╗    ║\n" +
                "║     ╚████╔╝  ██║ ██████╔╝ ███████╗ ╚██████╔╝ ╚██████╗ ███████╗ ╚██████╔╝ ██████╔╝    ║\n" +
                "║      ╚═══╝   ╚═╝ ╚═════╝  ╚══════╝  ╚═════╝   ╚═════╝ ╚══════╝  ╚═════╝  ╚═════╝     ║\n" +
                "╚══════════════════════════════════════════════════════════════════════════════════════╝\n" +
                "┌──────────────────────────────────────────────────────────────────────────────────────┐\n" +
                "│                             ¡Bienvenido a nuestro videoclub!                         │\n" +
                "└──────────────────────────────────────────────────────────────────────────────────────┘");
    }

    public int mostrarMenu(){
        int respuesta = 0;
        System.out.println("\t\t\t\t\t\t╔════════════════════════════════════════╗\n" +
                           "\t\t\t\t\t\t║                  MENÚ                  ║\n" +
                           "\t\t\t\t\t\t╠════════════════════════════════════════╣\n" +
                           "\t\t\t\t\t\t║                                        ║\n" +
                           "\t\t\t\t\t\t║ 1. Mostrar catálogo                    ║\n" +
                           "\t\t\t\t\t\t║ 5. Salir/Exit                          ║\n" +
                           "\t\t\t\t\t\t╚════════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
        respuesta = Peticiones.pedirRespuestaPrincipal();
        return respuesta;
    }
    public void mostrarPeliculas(List<Pelicula> peliculas){
        peliculas.stream().forEach(System.out::println);
    }

    public void mostrarMensajeError(String mensaje){
        String plantilla = "┌──────────────────────────────────────────────────────────────────────────────────────┐\n" +
                           "                                   %s                                   \n" +
                           "└──────────────────────────────────────────────────────────────────────────────────────┘";
        String mensajeFinal = String.format(plantilla, mensaje);
        System.out.println(mensajeFinal);
    }

    public void despedida(){
        System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────┐\n" +
                           "│                                Saliendo del programa.                                │\n" +
                           "│                                  ¡Hasta la próxima!                                  │\n" +
                           "└──────────────────────────────────────────────────────────────────────────────────────┘");
    }
}
