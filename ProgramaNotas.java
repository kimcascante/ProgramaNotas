package Tareas;

/**
 * Nombre del programa: Programa de Notas
 * Descripcion: La Universidad “Los Caperuzos” lo ha contratado a usted para que el
diseño y la implementación de un programa en Java que le permita
resolver el problema que se le ha presentado debido al crecimiento en el
curso de Animación Digital. La desea un programa que siga las
siguientes reglas;
a. Debe usar un arreglo para almacenar las notas.
b. Debe organizar su programa con rutinas.
c. Debe contar con un menú que tenga las siguientes opciones:
i. Ingresar la cantidad total de estudiantes (para poder definir
el tamaño del arreglo de notas)
ii. Registrar la nota de UN estudiante (el programa deberá
registrar la nota de los estudiantes uno por uno)
iivii. Imprimir nota más alta
. Imprimir la nota más baja.
v. Imprimir promedio general del curso.
vi. Salir del programa
 * Autor: Kimberly C 
 * Fecha de creacion:
 * Modificado por: Kimberly C 
 * fecha de modificacion:
 */

import java.io.*;

public class tarea5 {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        // int arreglo notas;
        menuOpciones();

    }// fin del main

    public static void menuOpciones() throws IOException {

        boolean salir = false;

        do {
            mostrarMenu();
            int opcion = leerOpcion();
            salir = ejecutar(opcion);
        } while (!salir);
    }// fin del menuOpciones

    static void mostrarMenu() {
        out.println();
        out.println("1. Ingresar la cantidad total de estudiantes.");
        out.println("2. Registrar la nota del primer estudiante.");
        out.println("3. Imprimir nota más alta.");
        out.println("4. Imprimir la nota más baja.");
        out.println("5. Imprimir promedio general del curso.");
        out.println("6. Salir.");
        out.println();
    }// fin del mostrarMenu

    static int leerOpcion() {
        try {
            out.println("Seleccione una opción:");
            int opcion = Integer.parseInt(in.readLine());
            out.println();
            return opcion;
        } catch (Exception iOException) {
            return -1;
        } // fin del catch
    }// fin del leerOpcion

    static boolean ejecutar(int caso) throws IOException {
        boolean salir = false;
        int cantEstudiantes = 0;
        int nota = 0;
        int notaMayor = 0, notaMenor = 0;
        int promedio = 0, notas = 0;

        switch (caso) {
            case 1:
                out.println("Digite la cantidad de estudiantes.");
                cantEstudiantes = Integer.parseInt(in.readLine());

            case 2:
                int[] arregloNotas = new int[cantEstudiantes];
                for (int i = 0; i < cantEstudiantes; i++) {
                    out.println("Digite la nota del estudiante " +(i+1));
                    nota = Integer.parseInt(in.readLine());
                    arregloNotas[i] = nota;
                    notas += arregloNotas[i];

                    if (i == 0) {
                        notaMenor = nota;
                        notaMayor = nota;
                    } else if (arregloNotas[i] >= notaMenor) {
                        notaMayor = arregloNotas[i];

                    } else if (nota < notaMenor) {
                        notaMenor = arregloNotas[i];
                    }

                    promedio = notas / cantEstudiantes;
                }

            case 3:
                out.println("La nota más alta es: " + notaMayor);
                out.println("Digite 4 para ver nota más baja..");
                notaMayor = Integer.parseInt(in.readLine());

                
            case 4:
                out.println("La nota más baja es: " + notaMenor);
                out.println("Digite 5 para ver el promedio..");
                notaMenor = Integer.parseInt(in.readLine());
                
            case 5:
                out.println("El promedio general es: " + promedio);
                out.println("Digite 6 para salir..");
                promedio = Integer.parseInt(in.readLine());

            case 6:
                salir = true;

            default:
                out.println("Saliendo...");
                out.println();
                break;
        }// fin del switch

        return salir;
    }// fin del boolean
}// Fin de la clase