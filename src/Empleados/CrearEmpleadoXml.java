package Empleados;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearEmpleadoXml {
    static void CrearElemento(String datoEmple, String valor, Element raiz, Document document){
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }

    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\DAT\\AleatorioEmple2.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int id , dep , posicion=0;
        Double salario;
        char[] apellido = new char[10];
        char aux;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0");

            for (;;) {
                file.seek(posicion); //nos posicionamos
                id=file.readInt(); // obtengo id del empleado
                for (int i = 0; i < apellido.length; i++) {
                    aux = file.readChar();
                    apellido[i] = aux;
                }
                String apellidos = new String(apellido);
                dep = file.readInt();
                salario = file.readDouble();

                if (id > 0) {
                    Element raiz = document.createElement("empleado");
                    document.getDocumentElement().appendChild(raiz);

                    CrearElemento("id", Integer.toString(id), raiz, document);

                    CrearElemento("apellido", apellidos.trim(), raiz, document);

                    CrearElemento("dep", Integer.toString(dep), raiz, document);

                    CrearElemento("salario", Double.toString(salario), raiz, document);
                }
                posicion = posicion + 36;

                if (file.getFilePointer()==file.length()) break;
            }//fin del for que recorre
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Empleados.xml"));
            Transformer transformer = TransformerFactory. newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(source,result);
        } catch (Exception e) {System.err.println("ERROR: "+e);}
        file.close();
    }

}
