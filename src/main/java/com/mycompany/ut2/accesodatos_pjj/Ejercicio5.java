package com.mycompany.ut2.accesodatos_pjj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio5 {

    public static void main(String[] args) {

        File fichero = new File("quijote.txt");

        int lineas = 0;
        int contadorQuijote = 0;

        try (FileReader fr = new FileReader(fichero);
             BufferedReader br = new BufferedReader(fr)) {

            String linea;

            while ((linea = br.readLine()) != null) {
                lineas++;
                String[] palabras = linea.split(" ");

                for (int i = 0; i < palabras.length; i++) {
                   // para comprobar si coincide con "Quijote"
                    if (palabras[i].equals("Quijote")) {
                        contadorQuijote++;
                    }
                }
            }

            System.out.println("Numero total de lineas: " + lineas);
            System.out.println("La palabra Quijote aparece: " + contadorQuijote + " veces.");

        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}