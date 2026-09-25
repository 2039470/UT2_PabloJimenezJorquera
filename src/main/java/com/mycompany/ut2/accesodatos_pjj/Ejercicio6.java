/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut2.accesodatos_pjj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author DAM2P
 */
public class Ejercicio6 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        // el true del final es para abrir el archivo en modo append, es decir escribir al final sin borrar nada
        try(FileWriter fileWriter= new FileWriter("calificaciones.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
        for (int i = 1; i<=3; i++){
            System.out.println("nombe del alumno"+ i);
            String nombre= scanner.nextLine();
            
            System.out.println("nota");
            String nota= scanner.nextLine();
            
            //juntamos ambos string 
            bufferedWriter.write(nombre + nota);
        }
        
        }
        catch (IOException e){
            System.err.println("error al escribir en el arvhivo" + e.getMessage());
        }
    }
    
}
