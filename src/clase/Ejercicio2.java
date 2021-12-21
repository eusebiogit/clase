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
public class Ejercicio2 {

    public static void ejercicio2() {
        Scanner TECLADO = new Scanner(System.in);
        int asientosFilas;
        int filas;
        int contador;
        int billetes;
        System.out.println("Introduce el numero de filas en el autobus");
        filas = TECLADO.nextInt();
        System.out.println("Introduce el numero de asientos por fila en el autobus");
        asientosFilas = TECLADO.nextInt();
        contador = filas * asientosFilas;

        boolean[][] asientos = new boolean[filas][asientosFilas];
        boolean terminar = false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < asientosFilas; j++) {
                asientos[i][j] = true;
            }
        }
        do {

            System.out.println();
            System.out.println("Introduce el numero asientos a ocupar");
            billetes = TECLADO.nextInt();
            System.out.println("disposición antes de comprar");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < asientosFilas; j++) {
                    System.out.print(asientos[i][j] + " ");
                }
                System.out.println();
            }
            if (billetes == 0) {
                terminar = true;
            } else {
                if (contador >= billetes) {

                    for (int i = 0; i < filas && billetes > 0; i++) {
                        for (int j = 0; j < asientosFilas && billetes > 0; j++) {
                            if (asientos[i][j]) {
                                asientos[i][j] = false;
                                contador--;
                                billetes--;
                            }
                        }
                    }
                    System.out.println("disposición después de comprar");
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < asientosFilas; j++) {
                            System.out.print(asientos[i][j] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("no hay suficientes");
                }
            }
            System.out.println("contador");
            System.out.println(contador);
            if (contador == 0) {
                terminar = true;
            }

        } while (!terminar);
    }
}
