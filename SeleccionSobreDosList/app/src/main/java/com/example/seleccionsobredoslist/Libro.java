package com.example.seleccionsobredoslist;

public class Libro {
    private String nombre, autor, descripcion;
    private int foto;

    public Libro(String nombre, String autor, int descripcion) {
        this.nombre = nombre;
        this.autor = autor;
        this.descripcion = descripcion;
    }

    public Libro(String nombre, String autor, String descripcion, int foto) {
        this.nombre = nombre;
        this.autor = autor;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
