package ConvertirXML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class E04_Convertir_XML_HTML {
    public static void main(String[] args) throws IOException
    {

        String hojaEstilo = "C:\\Users\\aludam2\\IdeaProjects\\Acceso_a_Datos\\src\\ConvertirXML\\alumnosPlantilla.xsl";
        String datosAlumnos = "C:\\Users\\aludam2\\IdeaProjects\\Acceso_a_Datos\\src\\ConvertirXML\\alumnos.xml";

        File pagina_html = new File("C:\\Users\\aludam2\\IdeaProjects\\Acceso_a_Datos\\src\\ConvertirXML\\alumnos.html");
        FileOutputStream output = new FileOutputStream(pagina_html); //crear fichero HTML

        Source estilos =new StreamSource(hojaEstilo); //fuente XSL
        Source datos =new StreamSource(datosAlumnos); //fuente XML
        Result result = new StreamResult(output); //resultado de la transformaci�n

        try
        {
            Transformer transformer =
                    TransformerFactory.newInstance().newTransformer(estilos);

            transformer.transform(datos, result);	//obtiene el HTML
        }
        catch(Exception e){System.err.println("Error: "+e);}

        output.close();  //cerrar fichero


    }
}
