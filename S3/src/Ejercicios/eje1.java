package Ejercicios;

import java.util.Scanner;

public class eje1 {

    public static boolean esPosible(int indice, int sumaActual, int[] arr, int objetivo) {
        // Caso base: Si ya procesamos todos los números
        if (indice == arr.length) {
            return sumaActual == objetivo;
        }

        int num = arr[indice];
        boolean esMultiploDe3 = (num % 3 == 0);
        boolean esPar = (num % 2 == 0);

        // Regla: Verificar si el siguiente también es par
        boolean siguienteEsPar = false;
        if (indice + 1 < arr.length) {
            if (arr[indice + 1] % 2 == 0) {
                siguienteEsPar = true;
            }
        }

        // ¿La regla de los pares prohíbe elegir este número?
        boolean prohibidoPorReglaPar = (esPar && siguienteEsPar);

        // REGLA 1: Múltiplos de 3 son OBLIGATORIOS
        if (esMultiploDe3) {
            // Si es obligatorio pero la regla par lo prohíbe, esta rama muere (false)
            if (prohibidoPorReglaPar) {
                return false;
            }
            // Solo podemos intentar el camino donde LO INCLUIMOS
            return esPosible(indice + 1, sumaActual + num, arr, objetivo);
        }

        if (esPosible(indice + 1, sumaActual, arr, objetivo)) {
            return true;
        }

        if (!prohibidoPorReglaPar) {
            if (esPosible(indice + 1, sumaActual + num, arr, objetivo)) {
                return true;
            }
        }

        // Si ningún camino funcionó
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese cantidad de elementos N:");
        int n = sc.nextInt();

        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Ingresar numero: " + (i + 1));
            arreglo[i] = sc.nextInt();
        }

        System.out.println("Ingresar numero objetivo");
        int objetivo = sc.nextInt();

        // función recursiva
        if (esPosible(0, 0, arreglo, objetivo)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        sc.close();
    }

}