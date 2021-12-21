/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import java.util.Scanner;

/**
 *
 * @author ordenador
 */
public class Ejercicio1 {

    public static void ejercicio() {
        Scanner TECLADO = new Scanner(System.in);
        int numAsientos, numAsientosOc, contador;
        System.out.println("Introduce el numero de asientos en el autobus");
        numAsientos = TECLADO.nextInt();
        contador = numAsientos;
        boolean[] asientos = new boolean[numAsientos];
        for (int i = 0; i < numAsientos; i++) {
            asientos[i] = true;
        }
        boolean terminar = false;
        do {
            System.out.println("Cuantos asientos deseas ocupar (entre 1 y " + contador + ") y 0 para finalizar el programa: ");
            numAsientosOc = TECLADO.nextInt();
            if (numAsientosOc == 0) {
                System.out.println("Se acabo el programa");
                terminar = true;
            } else {
                if (contador >= numAsientosOc) {
                    String mensaje = "hay suficientes";
                    imprimir(asientos, mensaje);
                    for (int i = 0; i < asientos.length; i++) {
                        System.out.print(asientos[i] + " ");
                    }
                    System.out.println();
                    for (int i = 0; i < asientos.length && numAsientosOc > 0; i++) {
                        if (asientos[i]) {
                            asientos[i] = false;
                            contador--;
                            numAsientosOc--;
                        }
                    }
                    System.out.println();
                    imprimir(asientos, "despues de comprar");

                } else {
                    System.out.println("no hay suficientes");
                }
                if (contador == 0) {
                    terminar = true;
                }
                System.out.println("contador");
                System.out.println(contador);
            }
        } while (!terminar);
    }

    public static void imprimir(boolean array[], String mensaje) {
        System.out.print(mensaje);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
