package com.example.ejerciciorepaso1trimestre;

public class Factura {
    private int imagen;
    private String  precioh,modelo,seguro;
    private int tiempo;

    public Factura(){};

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
