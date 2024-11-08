package edu.badpals.videoclub.vista;

import edu.badpals.videoclub.modelo.Pelicula;

import java.util.List;

public class Vista {
    public void bienvenida(){
        String plantilla = """
                ╔══════════════════════════════════════════════════════════════════════════════════════╗
                ║    ██╗   ██╗ ██╗ ██████╗  ███████╗  ██████╗   ██████╗ ██╗      ██╗   ██╗ ██████╗     ║
                ║    ██║   ██║ ██║ ██╔══██╗ ██╔════╝ ██╔═══██╗ ██╔════╝ ██║      ██║   ██║ ██╔══██╗    ║
                ║    ██║   ██║ ██║ ██║  ██║ █████╗   ██║   ██║ ██║      ██║      ██║   ██║ ██████╔╝    ║
                ║    ╚██╗ ██╔╝ ██║ ██║  ██║ ██╔══╝   ██║   ██║ ██║      ██║      ██║   ██║ ██╔══██╗    ║
                ║     ╚████╔╝  ██║ ██████╔╝ ███████╗ ╚██████╔╝ ╚██████╗ ███████╗ ╚██████╔╝ ██████╔╝    ║
                ║      ╚═══╝   ╚═╝ ╚═════╝  ╚══════╝  ╚═════╝   ╚═════╝ ╚══════╝  ╚═════╝  ╚═════╝     ║
                ╚══════════════════════════════════════════════════════════════════════════════════════╝
                ┌──────────────────────────────────────────────────────────────────────────────────────┐
                │                             ¡Bienvenido a nuestro videoclub!                         │
                └──────────────────────────────────────────────────────────────────────────────────────┘
                                                           \\ /
                                                            v
                                                           ┌─┐┐
                                                   ╔══════════════════╗_
                                                   ║%s║ \\
                                                   ║%s║º │
                                                   ║%s║º │
                                                   ║%s║º │
                                                   ╚══════════════════╝──┘
                                                                                                          """;
        String colores = generarRGB();
        String saludo = String.format(plantilla, colores, colores, colores, colores);
        System.out.println(saludo);
    }

    private String generarRGB(){
        String fondorRojo = "\033[1;41m";
        String fondorVerde = "\033[1;42m";
        String fondorAzul = "\033[1;44m";
        String sinFondo = "\033[0m";
        String rgb = fondorRojo+ "      " + fondorVerde + "      " + fondorAzul + "      " + sinFondo;
        return rgb;
    }

    public int mostrarMenu(){
        int respuesta = 0;
        System.out.println("""
                           \t\t\t\t\t\t╔════════════════════════════════════════╗
                           \t\t\t\t\t\t║             MENÚ PRINCIPAL             ║
                           \t\t\t\t\t\t╠════════════════════════════════════════╣
                           \t\t\t\t\t\t║                                        ║
                           \t\t\t\t\t\t║ 1. Mostrar catálogo                    ║
                           \t\t\t\t\t\t║ 2. Consultar película                  ║
                           \t\t\t\t\t\t║ 3. Crear nueva película                ║
                           \t\t\t\t\t\t║ 4. Salir/Exit                          ║
                           \t\t\t\t\t\t╚════════════════════════════════════════╝""");
        System.out.print("Seleccione una opción: ");
        respuesta = Peticiones.pedirRespuestaPrincipal();
        return respuesta;
    }

    public int mostrarMenuConsulta(Pelicula pelicula){
        int respuesta = 0;
        String plantilla_menu ="""
                           \t\t\t\t\t\t┌────────────────────────────────────────┐
                           \t\t\t\t\t\t│      MENÚ DE CONSULTA DE PELÍCULA      │
                           \t\t\t\t\t\t│────────────────────────────────────────│
                           \t\t\t\t\t\t│%s\033[1;0m│
                           \t\t\t\t\t\t│────────────────────────────────────────│
                           \t\t\t\t\t\t│ 1. Mostrar detalles de la película     │
                           \t\t\t\t\t\t│ 2. Modificar datos                     │
                           \t\t\t\t\t\t│ 3. Eliminar película                   │
                           \t\t\t\t\t\t│ 4. Volver                              │
                           \t\t\t\t\t\t└────────────────────────────────────────┘""";
        int longitud_fija = 47;
        String color = "\033[1;34m";
        String titulo = color + pelicula.getTitulo();
        StringBuilder sb = new StringBuilder(titulo);
        while(sb.length() < longitud_fija){
            sb.append(" ");
        }
        String menuConsulta = String.format(plantilla_menu,sb.toString());
        System.out.println(menuConsulta);
        System.out.print("Seleccione una opción de consulta: ");
        respuesta = Peticiones.pedirRespuestaConsulta();
        return respuesta;
    }

    public void mostrarPeliculas(List<Pelicula> peliculas){
    for (Pelicula pelicula : peliculas){
        String color = pelicula.isDisponible()? "\033[1;32m": "\033[1;31m";
        String finColor = "\033[0m";
        System.out.println("\n\t\t"+color + pelicula.getTitulo() + finColor + ". Id: " + color+ pelicula.getId()+ finColor);
    }
    }

    public void mostrarDetallesPelicula(Pelicula pelicula){
        System.out.println("\nDetalles de la película seleccionada: ");
        System.out.println(pelicula);
    }

    public void mostrarMensaje(String mensaje){
        String plantilla = """
                           ┌──────────────────────────────────────────────────────────────────────────────────────┐
                           │%s │
                           └──────────────────────────────────────────────────────────────────────────────────────┘""";
        int longitud_fija = 85;
        int espacios_totales = longitud_fija - mensaje.length();
        int espacios_izqda = espacios_totales / 2;
        int espacios_derecha = espacios_totales - espacios_izqda;
        String mensaje_centrado = " ".repeat(espacios_izqda) + mensaje + " ".repeat(espacios_derecha);
        String cuadro_completo = String.format(plantilla, mensaje_centrado);
        System.out.println(cuadro_completo);
    }

    public void despedida(){
        System.out.println("""
                           ┌──────────────────────────────────────────────────────────────────────────────────────┐
                           │                                Saliendo del programa.                                │
                           │                                  ¡Hasta la próxima!                                  │
                           └──────────────────────────────────────────────────────────────────────────────────────┘""");
    }
}
