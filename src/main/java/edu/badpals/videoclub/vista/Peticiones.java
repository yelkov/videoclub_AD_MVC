package edu.badpals.videoclub.vista;

import java.util.Scanner;

public class Peticiones {
    public static int pedirRespuestaPrincipal(){
        Scanner sc = new Scanner(System.in);
        int respuesta = 0;
        String opcion = sc.nextLine().toLowerCase();
        switch(opcion){
            case "1":
            case "mostrar catalogo":
            case "mostrar catálogo":
                respuesta = 1;
                break;
            case "5":
            case "salir":
            case "exit":
                respuesta = 5;
                break;
            default:
                respuesta = 6;
                break;
        }
        return respuesta;
    }
}
