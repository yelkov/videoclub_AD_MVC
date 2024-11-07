package edu.badpals.videoclub;

import edu.badpals.videoclub.modelo.Pelicula;
import edu.badpals.videoclub.modelo.Tematica;

public class Main {
    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("Una","Joe", Tematica.asignarTematica("Ciencia ficción"),"Pues ta bien",true);

        String fondoAzulClaro = "\033[48;5;75m"; // Fondo azul claro
        String textoBlanco = "\033[38;5;15m"; // Texto blanco
        String reset = "\033[0m"; // Resetear los colores

        // Aquí va el texto ASCII con los colores aplicados
        String videoClubTexto = fondoAzulClaro + textoBlanco +
                "██╗░░░██╗ ██╗ ██████╗░ ███████╗ ░█████╗░ ░█████╗░ ██╗░░░░░ ██╗░░░██╗ ██████╗░\n" +
                "██║░░░██║ ██║ ██╔══██╗ ██╔════╝ ██╔══██╗ ██╔══██╗ ██║░░░░░ ██║░░░██║ ██╔══██╗\n" +
                "╚██╗░██╔╝ ██║ ██║░░██║ █████╗░░ ██║░░██║ ██║░░╚═╝ ██║░░░░░ ██║░░░██║ ██████╦╝\n" +
                "░╚████╔╝░ ██║ ██║░░██║ ██╔══╝░░ ██║░░██║ ██║░░██╗ ██║░░░░░ ██║░░░██║ ██╔══██╗\n" +
                "░░╚██╔╝░░ ██║ ██████╔╝ ███████╗ ╚█████╔╝ ╚█████╔╝ ███████╗ ╚██████╔╝ ██████╦╝\n" +
                "░░░╚═╝░░░ ╚═╝ ╚═════╝░ ╚══════╝ ░╚════╝░ ░╚════╝░ ╚══════╝ ░╚═════╝░ ╚═════╝░" + reset;

        // Imprimir el texto con los colores
        System.out.println(videoClubTexto);

        System.out.println(pelicula);
    }
}