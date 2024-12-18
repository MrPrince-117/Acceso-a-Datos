package Dickson_Mayas;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.JAXBElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VisualizarXML {

    public static void visualizar() {
        try {
            // Creamos el contexto JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Deserializamos el XML
            JAXBElement<VentasType> jaxbElement = (JAXBElement<VentasType>) unmarshaller.unmarshal(new File("C:\\Users\\aludam2\\IdeaProjects\\Acceso_a_Datos\\ventasarticulo.xml"));

            // Visualiza por consola
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(jaxbElement, System.out);

            // Cargamos ahora el documento en los tipos VentasType
            VentasType miVenta = jaxbElement.getValue();

            // Obtenemos una instancia para obtener todas las ventas
            Ventas ventas = miVenta.getVentas();

            // Guardamos las ventas en la lista
            List<Ventas.Venta> listaVentas = new ArrayList<>(ventas.getVenta());

            System.out.println("--- VISUALIZAR LOS OBJETOS ---");

            // Cargamos los datos del artículo
            DatosArtic miArtic = (DatosArtic) miVenta.getArticulo();
            System.out.println("Nombre artículo: " + miArtic.getDenominacion());
            System.out.println("Código artículo: " + miArtic.getCodigo());
            System.out.println("Ventas del artículo: " + listaVentas.size());

            // Visualizamos las ventas del artículo
            for (int i = 0; i < listaVentas.size(); i++) {
                Ventas.Venta ve = listaVentas.get(i);
                System.out.println("Número de venta: " + ve.getNumventa() +
                        ", Nombre cliente: " + ve.getNombrecliente() +
                        ", Unidades: " + ve.getUnidades() +
                        ", Fecha: " + ve.getFecha());
            }
        } catch (JAXBException je) {
            System.out.println(je.getCause());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}//Fin class
