package com.mycompany.ut2.accesodatos_pjj;

import java.io.File;

public class Ejercicio3 {
    public static void main(String[] args) {
        
        // Definimos la ruta de carpetas anidadas
        File carpetas = new File("MurciaFP/2026/AccesoDatos");

        // Creamos la estructura completa de carpetas
        if (carpetas.mkdirs()) {
            System.out.println("Estructura de carpetas creada correctamente.");
        } else {
            System.out.println("No se han podido crear las carpetas.");
        }

        // Definimos el objeto con la ruta final que queremos que tenga
        File carpetaNueva = new File("MurciaFP/2026/AD_Backup");

        // Cambiamos el nombre de la carpeta AccesoDatos por AD_Backup
        if (carpetas.exists()) {
            if (carpetas.renameTo(carpetaNueva)) {
                System.out.println("Carpeta renombrada a AD_Backup con exito.");
            } else {
                System.out.println("Error al intentar renombrar la carpeta.");
            }
        }
    }
}