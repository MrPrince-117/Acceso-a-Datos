package UD6.Ej1_Persistencia;

import java.io.Serializable;

public class Producto implements Serializable {
    private String descripcion;
    private int  idproducto;
    private int stockactual;
    private int stockminimo;
    private float pvp;

    //Metodos getter y setter
    public Producto(String descripcion, int idproducto, int stockactual, int stockminimo, float pvp) {
        this.descripcion = descripcion;
        this.idproducto = idproducto;
        this.stockactual = stockactual;
        this.stockminimo = stockminimo;
        this.pvp = pvp;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getIdproducto() {
        return idproducto;
    }
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    public int getStockactual() {
        return stockactual;
    }
    public void setStockactual(int stockactual) {
        this.stockactual = stockactual;
    }
    public int getStockminimo() {
        return stockminimo;
    }
    public void setStockminimo(int stockminimo) {
        this.stockminimo = stockminimo;
    }
    public float getPvp() {
        return pvp;
    }
    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

}
