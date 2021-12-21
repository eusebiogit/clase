package clase;

import java.util.Scanner;

/**
 *
 * @author ordenador
 */
public class Clase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int array[] = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        imprimir(array);

    }

    public static void imprimir(int array[]) {
        for (int i = 0; i <= array.length; i++) {
            System.out.println(array[i % array.length ] + " ");
        }
    }
}
