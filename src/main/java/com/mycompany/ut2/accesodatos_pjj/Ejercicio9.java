package com.mycompany.ut2.accesodatos_pjj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio9 {

    public static void main(String[] args) {

        String archivo = "datos_notas.txt";

        // Abrimos el archivo garantizando el cierre automatico
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;
            int numLinea = 0;

            System.out.println("leyendo notas de " + archivo);

            while ((linea = br.readLine()) != null) {
                numLinea++;

                // try-catch interno para validar cada linea por separado
                try {
                    double nota = Double.parseDouble(linea.trim());
                    System.out.println("Linea " + numLinea + "Nota valida: " + nota);

                } catch (NumberFormatException e) {
                    System.err.println("no es una nota valida.");
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}