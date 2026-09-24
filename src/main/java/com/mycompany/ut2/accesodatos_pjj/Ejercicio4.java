package com.mycompany.ut2.accesodatos_pjj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio4 {

    public static void main(String[] args) {

        // Archivo original y archivo donde se va a guardar la copia
        String origen = "logo.png";
        String destino = "copia_logo.png";

        // Usamos try-with-resources para que Java cierre los ficheros solo al acabar
        try (FileInputStream file_input_str = new FileInputStream(origen);
             FileOutputStream file_output_str = new FileOutputStream(destino)) {

            int byteLeido;

            // Leemos byte a byte hasta que el flujo nos devuelva -1 (fin del archivo)
            while ((byteLeido = file_input_str.read()) != -1) {
                file_output_str.write(byteLeido);
            }

            System.out.println("Copia de seguridad hecha.");

        } catch (IOException e) {
            System.err.println("Error al procesar la copia de la imagen: " + e.getMessage());
        }
    }
}