package com.mycompany.ut2.accesodatos_pjj;

import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce la ruta donde quieras buscar el fichero:");
        String rutaUsuario = in.nextLine();
        
        // Usamos el constructor File(directorio, archivo)
        File buscar_fichero = new File(rutaUsuario, "temp.bak");

        if (buscar_fichero.exists()) {
            if (buscar_fichero.delete()) {
                System.out.println("Se ha borrado correctamente el fichero.");
            } else {
                System.out.println("No se ha podido borrar el fichero.");
            }
        } else {
            System.out.println("No existe el fichero.");
        }
    }
}
