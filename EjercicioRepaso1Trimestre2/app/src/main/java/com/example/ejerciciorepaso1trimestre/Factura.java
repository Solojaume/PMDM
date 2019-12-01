package com.example.ejerciciorepaso1trimestre;

import java.io.Serializable;

public class Factura implements Serializable {
    private int imagen;
    private String  precioh,modelo,seguro,total;
    private int tiempo,extras;

    public Factura(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Factura(){};

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public Factura(int imagen, String precioh, String modelo, String seguro, int tiempo) {
        this.imagen = imagen;
        this.precioh = precioh;
        this.modelo = modelo;
        this.seguro = seguro;
        this.tiempo = tiempo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getPrecioh() {
        return precioh;
    }

    public void setPrecioh(String precioh) {
        this.precioh = precioh;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
