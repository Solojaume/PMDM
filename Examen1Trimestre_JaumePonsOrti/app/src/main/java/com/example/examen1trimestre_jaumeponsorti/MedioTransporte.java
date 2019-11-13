package com.example.examen1trimestre_jaumeponsorti;

class MedioTransporte {
    private String tipo, marca,precio;
    private int imagen;

    public MedioTransporte(String tipo, String marca, String precio) {
        this.tipo = tipo;
        this.marca = marca;
        this.precio = precio;
    }

    public MedioTransporte(String tipo, String marca, String precio, int imagen) {
        this.tipo = tipo;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getPrecio() {
        return precio;
    }

    public int getImagen() {
        return imagen;
    }
}
