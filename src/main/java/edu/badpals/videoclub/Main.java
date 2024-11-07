package edu.badpals.videoclub;

import edu.badpals.videoclub.modelo.BDPelicula;
import edu.badpals.videoclub.modelo.Pelicula;
import edu.badpals.videoclub.modelo.Tematica;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BDPelicula bd = new BDPelicula();
        bd.conectarBD();
        System.out.println("\n" +
                "╔══════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║    ██╗   ██╗ ██╗ ██████╗  ███████╗  ██████╗   ██████╗ ██╗      ██╗   ██╗ ██████╗     ║\n" +
                "║    ██║   ██║ ██║ ██╔══██╗ ██╔════╝ ██╔═══██╗ ██╔════╝ ██║      ██║   ██║ ██╔══██╗    ║\n" +
                "║    ██║   ██║ ██║ ██║  ██║ █████╗   ██║   ██║ ██║      ██║      ██║   ██║ ██████╔╝    ║\n" +
                "║    ╚██╗ ██╔╝ ██║ ██║  ██║ ██╔══╝   ██║   ██║ ██║      ██║      ██║   ██║ ██╔══██╗    ║\n" +
                "║     ╚████╔╝  ██║ ██████╔╝ ███████╗ ╚██████╔╝ ╚██████╗ ███████╗ ╚██████╔╝ ██████╔╝    ║\n" +
                "║      ╚═══╝   ╚═╝ ╚═════╝  ╚══════╝  ╚═════╝   ╚═════╝ ╚══════╝  ╚═════╝  ╚═════╝     ║\n" +
                "╚══════════════════════════════════════════════════════════════════════════════════════╝\n");
        List<Pelicula> peliculas = bd.selectPeliculas();
        peliculas.forEach(System.out::println);
        bd.desconectarBD();

    }
}