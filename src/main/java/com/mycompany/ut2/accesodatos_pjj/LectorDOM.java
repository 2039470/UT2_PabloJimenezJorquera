package com.mycompany.ut2.accesodatos_pjj;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
/**
 *
 * @author DAM2P
 */
public class LectorDOM {
    public static void main(String[] args) {
        try {
            // 1. Instanciamos la factoría y el constructor de documentos DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // 2. Parseamos el archivo cargándolo en memoria por completo
            Document doc = builder.parse(new File("alumnos_murcia.xml"));
            
            // Opcional: Normaliza la estructura del árbol de nodos
            doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            
            // 3. Obtenemos la lista de todos los nodos "alumno"
            NodeList listaAlumnos = doc.getElementsByTagName("alumno");
            
            for (int i = 0; i < listaAlumnos.getLength(); i++) {
                Node nodo = listaAlumnos.item(i);
                
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    
                    // Extraemos un atributo
                    String id = elemento.getAttribute("id");
                    // Extraemos los elementos hijos de texto
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    String ciclo = elemento.getElementsByTagName("ciclo").item(0).getTextContent();
                    
                    System.out.println("ID: " + id + " | Alumno: " + nombre + " | Ciclo: " + ciclo);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al parsear con DOM: " + e.getMessage());
        }
    }
}
