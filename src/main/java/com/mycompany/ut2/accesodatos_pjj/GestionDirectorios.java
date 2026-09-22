/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut2.accesodatos_pjj;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author pjj
 */
public class GestionDirectorios {
    public static void main(String[] args) {
        //Definimos una ruta base para las prácticas del ciclo
        String rutaBase = "PracticasDAM";
        File directorioBase = new File(rutaBase);
        System.out.println("=Iniciando Gestión de Ficheros");
         // 2. Creación de directorios
        if (!directorioBase.exists()) {
            if (directorioBase.mkdir()) {
                System.out.println("✔ Directorio '" + rutaBase + "' creado con éxito.");
            }
        } else {
            System.out.println("ℹ El directorio '" + rutaBase + "' ya existía.");
        }

        // 3. Creación de un fichero dentro del directorio recién validado
        File nuevoFichero = new File(directorioBase, "notas_evaluacion.txt");
        
        try {
            if (nuevoFichero.createNewFile()) {
                System.out.println("✔ Fichero '" + nuevoFichero.getName() + "' creado correctamente.");
            } else {
                System.out.println("ℹ El fichero '" + nuevoFichero.getName() + "' ya existe en el disco.");
            }
            
            // 4. Mostrar metadatos esenciales del objeto File
            System.out.println("\n--- Propiedades del Fichero ---");
            System.out.println("Ruta absoluta: " + nuevoFichero.getAbsolutePath());
            System.out.println("¿Es un fichero ejecutable?: " + nuevoFichero.canExecute());
            System.out.println("Tamaño actual en bytes: " + nuevoFichero.length());

        } catch (IOException e) {
            System.err.println("❌ Error al crear el archivo físico: " + e.getMessage());
        }
    }
}
    

