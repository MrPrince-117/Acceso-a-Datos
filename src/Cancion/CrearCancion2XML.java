package Cancion;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;




public class CrearCancion2XML {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\aludam2\\Desktop\\DAT\\Canciones.dat");

        FileInputStream filleIn = new FileInputStream(f);
        ObjectInputStream objIn = new ObjectInputStream(filleIn);
       Cancion cancion;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Canciones", null);//se crea en la RAM
            document.setXmlVersion("1.0");

            for (int i =0; i<1; i++){
                cancion = (Cancion) objIn.readObject();

                //Añadimos nodo raiz
                Element raiz = document.createElement("Cancion");

                //Añadimos nodo principal
                document.getDocumentElement().appendChild(raiz);

                CrearElemento("id",Integer.toString(cancion.getId()),raiz,document);
                CrearElemento("año",Integer.toString(cancion.getAño()),raiz,document);
                CrearElemento("titulo",cancion.getTitulo(),raiz,document);
                CrearElemento("artista",cancion.getAutor(),raiz,document);
                CrearElemento("duracion",cancion.getDuracion(),raiz,document);
                CrearElemento("Es_Española",Boolean.toString(cancion.getCancionEspañola()),raiz,document);
            }
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Canciones2.xml"));
            Transformer transformer = TransformerFactory. newInstance().newTransformer();
            transformer.transform(source, result);

            //MOSTRAR EL DOCUMENTO POR CONSOLA
            Result console = new StreamResult(System.out);
            transformer.transform(source, console);

        } catch (ParserConfigurationException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);

        } finally {
            filleIn.close();
            objIn.close();
        }
    }
    static void CrearElemento (String datoCan, String valor, Element raiz, Document document) {
        Element elem = document.createElement("datoCanciones");
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }//Fin CrearElemento
}
