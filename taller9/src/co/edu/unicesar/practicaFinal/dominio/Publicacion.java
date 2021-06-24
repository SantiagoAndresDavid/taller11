package co.edu.unicesar.practicaFinal.dominio;

import java.io.Serializable;

public abstract class Publicacion implements Serializable {
    private String ISBN;
    private String titulo;
    private int año;
    private String autor;
    private double costo;

    public Publicacion() {
    }

    public Publicacion(String ISBN, String titulo, int año, String autor, double costo) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.año = año;
        this.autor = autor;
        this.costo = costo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }


    public String getDataText() {
        return  this.ISBN + ";"
                + this.titulo + ";"
                + this.año + ";"
                + this.autor + ";"
                + this.costo;
    }


    public String getInfo() {
        return "PUBLICACION" +
                "\n---------------------------------------------------------------------------------------------------" +
                "\nISBN: " + ISBN +
                "\nTitulo: " + titulo +
                "\nAño: " + año +
                "\nAutor: " + autor +
                "\nCosto: " + costo;
    }

    @Override
    public String toString() {
        return "PUBLICACION" +
                "\n---------------------------------------------------------------------------------------------------" +
                "\nISBN: " + ISBN +
                "\nTitulo: " + titulo +
                "\nAño: " + año +
                "\nAutor: " + autor +
                "\nCosto: " + costo;
    }


}
