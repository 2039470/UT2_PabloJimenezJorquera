package com.mycompany.ut2.accesodatos_pjj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("introduce la ruta del archivo : ");
        String ruta = in.nextLine();

        // Usamos try-with-resources para garantizar el cierre automatico
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            System.out.println("archivo abierto con exito.");
            
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            
            System.err.println("Aviso: No se ha encontrado el archivo en la ruta especificada.");

        } catch (IOException e) {
            System.err.println("Error general de Entrada/Salida: " + e.getMessage());
        }
    }
}