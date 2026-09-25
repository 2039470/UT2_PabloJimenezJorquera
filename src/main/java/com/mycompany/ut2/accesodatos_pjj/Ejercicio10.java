package com.mycompany.ut2.accesodatos_pjj;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
//profe este esta hecho full con IA no tenia ni idea de como se hacia la verdad, si en el lab hay que hacer lo mismo tendre que ponerme a verlo jaja
public class Ejercicio10 {

    public static void main(String[] args) {

        try {
            // 1. Creamos la factoria y el constructor de documentos DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 2. Creamos un documento XML vacio en memoria
            Document doc = builder.newDocument();

            // 3. Creamos el elemento raiz <instituto> y lo añadimos al documento
            Element instituto = doc.createElement("instituto");
            doc.appendChild(instituto);

            // 4. Creamos el elemento <modulo>
            Element modulo = doc.createElement("modulo");

            // Le añadimos el atributo codigo="DAM"
            modulo.setAttribute("codigo", "DAM");

            // Le añadimos el texto "Acceso a Datos"
            modulo.setTextContent("Acceso a Datos");

            // Añadimos <modulo> dentro de <instituto>
            instituto.appendChild(modulo);

            // 5. Transformamos la estructura DOM en un archivo XML en disco (instituto.xml)
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Propiedad para que el XML tenga sangria y saltos de linea legibles
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource origen = new DOMSource(doc);
            StreamResult destino = new StreamResult(new File("instituto.xml"));

            // Escribimos el XML
            transformer.transform(origen, destino);

            System.out.println("Archivo 'instituto.xml' generado correctamente mediante DOM.");

        } catch (Exception e) {
            System.err.println("Error al generar el documento XML: " + e.getMessage());
        }
    }
}