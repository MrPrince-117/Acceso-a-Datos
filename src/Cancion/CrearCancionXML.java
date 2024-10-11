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

public class CrearCancionXML {
    public static void main(String[] args) throws FileNotFoundException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\DAT\\CancionesAleatorias.dat");
        RandomAccessFile file = new RandomAccessFile(fichero,"r");
        int posicion=0;
        Double salario;
        char titulo[] = new char[20];
        char artista[] = new char[20],aux ,auy,auz;
        char duracion[] = new char[20];
        int id;
        int año;
        boolean cancionEspañola;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation domImpl = builder.getDOMImplementation();
            Document document = domImpl.createDocument(null, "Canciones", null);
            document.setXmlVersion("1.0");
            for(;;){
                file.seek(posicion);
                id=file.readInt();
                año=file.readInt();
                for(int i=0; i<titulo.length; i++){
                    aux = file.readChar();
                    titulo[i] =aux;
                }
                String titulos = new String(titulo);
                for(int i=0; i<artista.length; i++){
                    auy = file.readChar();
                    titulo[i] =auy;
                }
                String artistas = new String(titulo);
                for(int i=0; i<duracion.length; i++){
                    auz= file.readChar();
                    duracion[i] =auz;
                }
                String duraciones = new String(duracion);
                cancionEspañola = file.readBoolean();
                if(id>0){
                    Element raiz = document.createElement("cancion");
                    document.getDocumentElement().appendChild(raiz);
                    CrearElemento("id",Integer.toString(id),raiz,document);
                    CrearElemento("año",Integer.toString(año),raiz,document);
                    CrearElemento("titulo",titulos.trim(),raiz,document);
                    CrearElemento("artista",artistas.trim(),raiz,document);
                    CrearElemento("duracion",duraciones.trim(),raiz,document);
                    CrearElemento("Es_Española",Boolean.toString(cancionEspañola),raiz,document);
                }
                posicion=posicion+129;
                if(file.getFilePointer() == file.length()) break;
            }
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Canciones.xml"));
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.transform(source,result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }
    static void CrearElemento (String datoCan, String valor, Element raiz, Document document) {
        Element elem = document.createElement("datoCanciones");
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }//Fin CrearElemento
}
