package clase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ordenador
 */
public class Clase {

    /**
     * Se prueban los métodos realizados
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
        
        
        
        
        
        
    }

    /**
     * Usamos el método escribirArchivo para guardar los nombres y los apodos en
     * un formato apropiado para poder leer después
     *
     * @param nombre
     * @param apodo
     */
    private static void guardarNombreApodo(String nombre, String apodo) {
        escribirArchivo(nombre + "-" + apodo + "\n", "usuarios.txt");
    }

    /**
     * Método útil para escribir un string en un archivo de nombre dado
     * @param texto
     * @param nombreArchivo
     */
    private static void escribirArchivo(String texto, String nombreArchivo) {
        try {
            FileWriter user = new FileWriter(nombreArchivo, true);
            user.write(texto);
            user.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Comprueba si un apodo dado está o no registrado en el archivo
     * @param apodo
     * @return
     */
    private static boolean apodoRegistrado(String apodo) {
        File doc = new File("usuarios.txt");
        FileReader freader;
        String texto;
        String apodoAux;
        String datos[];
        boolean registrado = false;
        try {
            freader = new FileReader(doc);
            BufferedReader br = new BufferedReader(freader);
            //se lee línea a línea en cada iteración
            do {
                texto = br.readLine();
                if (texto != null) {  //si hay línea
                    datos = texto.split("-");   //Split corta el string por el patron y devuelve un array de string con los trozos del corte
                                               // "pepe-pepe2".split("-")  =>  {pepe,pepe2}
                    apodoAux = datos[1];
                    registrado = apodoAux.equals(apodo);     //apodoaux igual que apodo pasado por argumento
                }
            } while (texto != null && !registrado);
            freader.close();
        } catch (Exception err) {
            Logger.getLogger(Debate.class.getName()).log(Level.SEVERE, null, err);
        }
        return registrado;
    }

    /**
     * Comprueba si un nombre dado está o no registrado en el archivo
     * @param apodo
     * @return
     */
    private static boolean nombreRegistrado(String nombre) {
        File doc = new File("usuarios.txt");
        FileReader freader;
        String texto;
        String nombreAux;
        String datos[];
        boolean registrado = false;
        try {
            freader = new FileReader(doc);
            BufferedReader br = new BufferedReader(freader);
            do {
                texto = br.readLine();
                if (texto != null) {
                    datos = texto.split("-");
                    //solo habría que cambiar esto respecto al anterior método si lo que se quiere comprobar es el nombre
                    nombreAux = datos[0];
                    registrado = nombreAux.equals(nombre);
                }
            } while (texto != null && !registrado);
            freader.close();
        } catch (Exception err) {
            Logger.getLogger(Debate.class.getName()).log(Level.SEVERE, null, err);
        }
        return registrado;
    }

    /**
     * Dado un apodo devuelve el nombre que se ha registrado en función de ese
     * apodo
     * @param apodo
     * @return
     */
    private static String getNombreByApodo(String apodo) {
        File doc = new File("usuarios.txt");
        FileReader freader;
        String texto;
        String nombre = null;
        String datos[];
        try {
            freader = new FileReader(doc);
            BufferedReader br = new BufferedReader(freader);
            do {
                texto = br.readLine();
                if (texto != null) {
                    datos = texto.split("-");
                    if (datos[1].equals(apodo)) {  //Si el apodo está en esa línea
                        nombre = datos[0];          //se coge el nombre
                    }
                }
            } while (texto != null && nombre == null);
            freader.close();
        } catch (Exception err) {
            Logger.getLogger(Debate.class.getName()).log(Level.SEVERE, null, err);
        }
        return nombre;
    }

    /**
     * Dado un nombre devuelve el apodo que se ha registrado en función de ese
     * nombre
     * @param nombre
     * @return
     */
    private static String getApodoByNombre(String nombre) {
        File doc = new File("usuarios.txt");
        FileReader freader;
        String texto;
        String apodo = null;
        String datos[];
        try {
            freader = new FileReader(doc);
            BufferedReader br = new BufferedReader(freader);
            do {
                texto = br.readLine();
                if (texto != null) {
                    datos = texto.split("-");
                    if (datos[0].equals(nombre)) {
                        apodo = datos[1];
                    }
                }
            } while (texto != null && apodo == null);
            freader.close();
        } catch (Exception err) {
            Logger.getLogger(Debate.class.getName()).log(Level.SEVERE, null, err);
        }
        return apodo;
    }

}
