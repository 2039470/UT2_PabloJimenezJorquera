/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut2.accesodatos_pjj;

/**
 *
 * @author DAM2P
 */
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;

public class LectorSAX {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Definimos el manejador de eventos en línea (o en una clase interna)
            DefaultHandler manejador = new DefaultHandler() {
                private boolean esNombre = false;
                private boolean esCiclo = false;

                // Evento: Se encuentra una etiqueta de apertura
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("alumno")) {
                        String id = attributes.getValue("id");
                        System.out.print("ID Alumno: " + id);
                    } else if (qName.equalsIgnoreCase("nombre")) {
                        esNombre = true;
                    } else if (qName.equalsIgnoreCase("ciclo")) {
                        esCiclo = true;
                    }
                }

                // Evento: Se procesa el texto plano dentro de una etiqueta
                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (esNombre) {
                        System.out.print(" | Nombre: " + new String(ch, start, length));
                        esNombre = false;
                    } else if (esCiclo) {
                        System.out.println(" | Ciclo: " + new String(ch, start, length));
                        esCiclo = false;
                    }
                }

                // Evento: Se encuentra una etiqueta de cierre
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // Control de fin de bloques si fuera necesario
                }
            };

            // Lanzamos el análisis secuencial del archivo
            saxParser.parse(new File("alumnos_murcia.xml"), manejador);

        } catch (Exception e) {
            System.err.println("Error al parsear con SAX: " + e.getMessage());
        }
    }
}
