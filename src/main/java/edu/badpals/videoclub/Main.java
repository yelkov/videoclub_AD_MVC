package edu.badpals.videoclub;

import edu.badpals.videoclub.controlador.Controlador;
import edu.badpals.videoclub.modelo.Modelo;
import edu.badpals.videoclub.modelo.Pelicula;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.control();
    }
}