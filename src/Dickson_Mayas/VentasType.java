
package Dickson_Mayas;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para VentasType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="VentasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articulo" type="{}DatosArtic"/&gt;
 *         &lt;element name="ventas" type="{}ventas"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VentasType", propOrder = {
    "articulo",
    "ventas"
})
public class VentasType {

    @XmlElement(required = true)
    protected DatosArtic articulo;
    @XmlElement(required = true)
    protected Ventas ventas;

    /**
     * Obtiene el valor de la propiedad articulo.
     * 
     * @return
     *     possible object is
     *     {@link DatosArtic }
     *     
     */
    public DatosArtic getArticulo() {
        return articulo;
    }

    /**
     * Define el valor de la propiedad articulo.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosArtic }
     *     
     */
    public void setArticulo(DatosArtic value) {
        this.articulo = value;
    }

    /**
     * Obtiene el valor de la propiedad ventas.
     * 
     * @return
     *     possible object is
     *     {@link Ventas }
     *     
     */
    public Ventas getVentas() {
        return ventas;
    }

    /**
     * Define el valor de la propiedad ventas.
     * 
     * @param value
     *     allowed object is
     *     {@link Ventas }
     *     
     */
    public void setVentas(Ventas value) {
        this.ventas = value;
    }

}
