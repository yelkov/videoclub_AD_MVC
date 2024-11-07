package edu.badpals.videoclub.modelo;

import java.util.Arrays;

public enum Tematica {
    ACCION("Acción"),
    AVENTURA("Aventura"),
    CIENCIA_FICCION("Ciencia ficción"),
    ROMANCE("Romance"),
    TERROR("Terror");

    private String nombre;

    private Tematica(final String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public static Tematica asignarTematica(String nombre) {
        for (Tematica tematica : Tematica.values()) {
            if (tematica.getNombre().equalsIgnoreCase(nombre)) {
                return tematica;
            }
        }
        throw new IllegalArgumentException("No existe una temática con el nombre: " + nombre);
    }

    public void mostrarTematicas(){
        Arrays.stream(Tematica.values()).forEach(tematica -> System.out.println(tematica.getNombre()));
    }
}
