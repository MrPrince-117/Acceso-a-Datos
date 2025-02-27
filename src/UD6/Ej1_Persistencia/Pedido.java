package UD6.Ej1_Persistencia;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable , PropertyChangeListener {

    private int numeropedido;
    private int idproducto;
    private Date fecha;
    private int cantidad;
    private boolean pedir;

    public Pedido() {}
    public Pedido(int numeropedido, int idproducto, Date fecha, int cantidad, boolean pedir ) {
        this.numeropedido = numeropedido;
        this.idproducto = idproducto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.pedir = pedir;
    }
    public int getNumeropedido() {
        return numeropedido;
    }
    public void setNumeropedido(int numeropedido) {
        this.numeropedido = numeropedido;
    }
    public int getIdproducto() {
        return idproducto;
    }
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public boolean isPedir() {
        return pedir;
    }
    public void setPedir(boolean pedir) {
        this.pedir = pedir;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
