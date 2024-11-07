package edu.badpals.videoclub.modelo;

public class Pelicula {
    private int id;
    private String titulo;
    private String protagonista;
    private Tematica tematica;
    private String descripcion;
    private boolean disponible;

    public Pelicula(String titulo, String protagonista, Tematica tematica, String descripcion, boolean disponible) {
        this.titulo = titulo;
        this.protagonista = protagonista;
        this.tematica = tematica;
        this.descripcion = descripcion;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(String protagonista) {
        this.protagonista = protagonista;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String colorear = isDisponible() ? "\033[1;32m" : "\033[1;31m";
        String finColor = "\033[0m";

        sb.append("\n\t\tTítulo: " + colorear + titulo + finColor);
        sb.append("\n\t\tProtagonista: " + protagonista);
        sb.append("\n\t\tTemática: " + tematica.getNombre());
        sb.append("\n\t\tDescripción: " + descripcion);
        sb.append("\n\t\tDisponible: " + colorear + (isDisponible()? "Sí":"No") +finColor);
        return sb.toString();
    }
}
