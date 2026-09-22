/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut2.accesodatos_pjj;
import java.io.File;

/**
 *
 * @author DAM2P
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        //busca el fichero
        File archivo_buscar = new File("ficheros_dam");
        if(archivo_buscar.exists()){
            System.out.println("Existe");
            //miro si es un directorio
            if (archivo_buscar.isDirectory()){
                System.out.println("Es un directorio");
            }
        }
        //si no, creo el directorio y meto dentro el nuevo archivo
        else{
        archivo_buscar.mkdir();
        File archivo_vacio = new File("setup.log");
            System.out.println("No encuentro nada");
        }
    }
}
