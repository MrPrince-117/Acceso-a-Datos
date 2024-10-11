package Empleados;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class LeerEmpleadoXML {

        public static void main(String[] args) throws IOException, SAXException {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = dbf.newDocumentBuilder();
                Document doc = builder.parse(new File("Empleados.xml"));
                doc.getDocumentElement().normalize();
                System.out.printf("Elemento raiz: %s %n", doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("empleado");
                System.out.printf("Nodos empleado a recorrer: %s %n", nList.getLength());
                for (int i = 0; i < nList.getLength(); i++) {
                    Node nNode = nList.item(i);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) nNode;
                        System.out.println("----------------");
                        System.out.printf("ID = %s %n", element.getElementsByTagName("id").item(0).getTextContent());
                        System.out.printf("Apellido = %s %n", element.getElementsByTagName("apellido").item(0).getTextContent());
                        System.out.printf("Dep = %s %n", element.getElementsByTagName("dep").item(0).getTextContent());
                        System.out.printf("Salario = %s %n", element.getElementsByTagName("salario").item(0).getTextContent());
                        System.out.println("----------------");
                    }
                }
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            }
        }
}
