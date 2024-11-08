package edu.badpals.videoclub.vista;

import edu.badpals.videoclub.modelo.Pelicula;
import edu.badpals.videoclub.modelo.Tematica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Peticiones {
    public static int pedirRespuestaPrincipal(){
        Scanner sc = new Scanner(System.in);
        int respuesta = 0;
        String opcion = sc.nextLine().toLowerCase();
        switch(opcion){
            case "1","mostrar catalogo","mostrar catálogo":
                respuesta = 1;
                break;
            case "2","consultar pelicula","consultar película":
                respuesta = 2;
                break;
            case "3","crear","crear película","crear nueva pelicula","crear nueva película":
                respuesta = 3;
                break;
            case "4","salir","exit":
                respuesta = 4;
                break;
            default:
                respuesta = 5;
                break;
        }
        return respuesta;
    }

    public static Integer pedirIdPelicula(){
        Integer respuesta = null;

        int intentos = 0;
        while(intentos < 3){
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese el id de la película: ");
            try{
                respuesta = sc.nextInt();
                return respuesta;
            }catch (InputMismatchException e){
                intentos++;
                System.out.println("Recuerde introducir un número entero.");
                if(intentos == 3){
                    System.out.println("Se ha llegado al úmero máximo de intentos. Proceso abortado.");
                    return null;
                }
            }
        }
        return respuesta;
    }

    public static int pedirRespuestaConsulta(){
        Scanner sc = new Scanner(System.in);
        int respuesta = 0;
        String opcion = sc.nextLine().toLowerCase();
        switch(opcion){
            case "1", "mostrar detalles de pelicula", "mostrar detalles de película":
                respuesta = 1;
                break;
            case "2", "modificar datos":
                respuesta = 2;
                break;
            case "3","eliminar pelicula","eliminar película":
                respuesta = 3;
                break;
            case "4", "volver":
                respuesta = 4;
                break;
            default:
                respuesta = 5;
                break;
        }
        return respuesta;
    }

    public static String pedirConfirmacion(String nombreProceso){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n¿Desea confirmar el proceso de " + nombreProceso + "?(S/n): " );
        String opcion = sc.nextLine().toLowerCase();
        return opcion;
    }

    public static void pedirActualizaciones(Pelicula pelicula){
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Desea modificar el título?(S/n):  ");
        String opcion = sc.nextLine().toLowerCase();
        if(!opcion.equals("n") && !opcion.equals("no")){
            System.out.print("\n\tEscriba el nuevo título: ");
            pelicula.setTitulo(sc.nextLine());
        }

        System.out.print("¿Desea modificar el nombre del actor protagonista?(S/n): ");
        String opcion2 = sc.nextLine().toLowerCase();
        if(!opcion2.equals("n") && !opcion2.equals("no")){
            System.out.print("\n\tEscriba el nuevo nombre: ");
            pelicula.setProtagonista(sc.nextLine());
        }

        System.out.print("¿Desea modificar la temática?(S/n): ");
        String opcion3 = sc.nextLine().toLowerCase();
        if(!opcion3.equals("n") && !opcion3.equals("no")){
            System.out.print("\n\tElija entre las distintas temáticas: ");
            System.out.print("\n\t1.Acción | 2.Ciencia ficción | 3.Romance | 4.Terror ");
            String respuesta = sc.nextLine().toLowerCase();
            switch(respuesta){
                case "1","accion","acción":
                    pelicula.setTematica(Tematica.ACCION);
                    break;
                case "2","ciencia ficcion","ciencia ficción":
                    pelicula.setTematica(Tematica.CIENCIA_FICCION);
                    break;
                case "3","romance":
                    pelicula.setTematica(Tematica.ROMANCE);
                    break;
                case "4","terror":
                    pelicula.setTematica(Tematica.TERROR);
                    break;
                default:
                    System.out.println("\t\tLa temática escogida no existe. No se modificará.");
                    break;
            }
        }

        System.out.print("¿Desea modificar la descripción de la película?(S/n): ");
        String opcion4 = sc.nextLine().toLowerCase();
        if(!opcion4.equals("n") && !opcion4.equals("no")){
            System.out.print("\n\tEscriba la nueva descripcion: ");
            pelicula.setDescripcion(sc.nextLine());
        }

        boolean valido = false;
        while(!valido){
            System.out.print("¿Está la película disponible?(S/n): ");
            String opcion5 = sc.nextLine().toLowerCase();
            if(opcion5.equals("s") || opcion5.equals("si") || opcion5.equals("sí") || opcion5.isEmpty()){
                pelicula.setDisponible(true);
                valido = true;
            }else if(opcion5.equals("n") || opcion5.equals("no")){
                pelicula.setDisponible(false);
                valido = true;
            }else{
                System.out.println("\n\tOpción no válida. Responda 's' o 'n'.");
            }
        }

        System.out.println("\nLos cambios introducidos son: ");
        System.out.println("\t" + pelicula);
    }

    public static Pelicula pedirCreacion(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el nombre de la película: ");
        String nombre = sc.nextLine();
        System.out.print("Introduzca el nombre del actor protagonista: ");
        String protagonista = sc.nextLine();

        boolean valido = false;
        Tematica tematica = null;
        while(!valido){
            System.out.print("Seleccione una de las siguientes temáticas: ");
            System.out.print("\n\t1.Acción | 2.Ciencia ficción | 3.Romance | 4.Terror ");
            String respuesta = sc.nextLine().toLowerCase();
            switch(respuesta){
                case "1","accion","acción":
                    tematica = Tematica.ACCION;
                    valido = true;
                    break;
                case "2","ciencia ficcion","ciencia ficción":
                    tematica =  Tematica.CIENCIA_FICCION;
                    valido = true;
                    break;
                case "3","romance":
                    tematica =  Tematica.ROMANCE;
                    valido = true;
                    break;
                case "4","terror":
                    tematica =  Tematica.TERROR;
                    valido = true;
                    break;
                default:
                    System.out.println("\t\tLa temática escogida no existe. Seleccione entre las posibles opciones.");
                    break;
            }
        }
        System.out.print("Introduzca una breve descripcion: ");
        String descripcion = sc.nextLine();
        System.out.print("");

        boolean disponible = false;
        valido = false;
        while(!valido){
            System.out.print("¿Está la película disponible?(S/n): ");
            String opcion5 = sc.nextLine().toLowerCase();
            if(opcion5.equals("s") || opcion5.equals("si") || opcion5.equals("sí") || opcion5.isEmpty()){
                disponible = true;
                valido = true;
            }else if(opcion5.equals("n") || opcion5.equals("no")){
                disponible = false;
                valido = true;
            }else{
                System.out.println("\n\tOpción no válida. Responda 's' o 'n'.");
            }
        }
        System.out.println("\nLos datos recogidos son los siguientes: ");
        Pelicula pelicula = new Pelicula(nombre,protagonista,tematica,descripcion,disponible);
        System.out.println(pelicula);
        return pelicula;
    }
}
