/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut2.accesodatos_pjj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 *
 * @author DAM2P
 */
public class Ejercicio7 {
    public static void main(String[] args) throws FileNotFoundException {
        String archivo = "datos.dat";
        Random r = new Random();
        
        //abrimos el archivo en modo de lectura o escritura dentro del trywithresources para no tener que hacer el finally
        try(RandomAccessFile ficheroAccesoAleatorio = new RandomAccessFile(archivo, "rw")){
            // generamos 3 numeros aleatorios para que cada uno ocupe 4 bytes y luego saber a que posicion saltar
            ficheroAccesoAleatorio.writeInt(r.nextInt(100));
            ficheroAccesoAleatorio.writeInt(r.nextInt(100));
            ficheroAccesoAleatorio.writeInt(r.nextInt(100));
            
            System.out.println("3 numeros aleatorios guardados");
            
            ficheroAccesoAleatorio.seek(4);
            ficheroAccesoAleatorio.writeInt(999);
            System.out.println("numero modificado");
            // y volvemos a leer el archivo
            ficheroAccesoAleatorio.seek(0);
            System.out.println("Numero 1: " + ficheroAccesoAleatorio.readInt());
            System.out.println("Numero 2: " + ficheroAccesoAleatorio.readInt());
            System.out.println("Numero 3: " + ficheroAccesoAleatorio.readInt());
            
        }
        catch (IOException e){
            System.out.println("error al procesar el archivo" + e.getMessage());
        }
    }
}
