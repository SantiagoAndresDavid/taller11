package co.edu.unicesar.practicaFinal.dominio;

import java.io.Serializable;

public class AudioLibro extends Publicacion implements Serializable {
    private String tipo = "AudioLibro";
    private double duracion;
    private String formato;
    private double peso;

    public AudioLibro() {
    }

    public AudioLibro(String tipo,
                      String ISBN,
                      String titulo,
                      int año,
                      String autor,
                      double costo,
                      double duracion,
                      String formato,
                      double peso) {
        super(ISBN, titulo, año, autor, costo);
        this.duracion = duracion;
        this.formato = formato;
        this.peso = peso;
        this.tipo = tipo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataText() {
        return super.getDataText() + ";"
                + this.duracion + ";"
                + this.formato + ";"
                + this.peso + ";"
                + this.tipo;
    }

    public String getInfo() {
        return super.getInfo() +
                "\nDuracion: " + duracion +
                "\nFormato: " + formato +
                "\nPeso: " + peso +
                "\n---------------------------------------------------------------------------------------------------";
    }

    @Override
    public String toString() {
        return super.toString()+
                "\ntipo:" + tipo +
                "\nduracion:" + duracion +
                "\nformato:" + formato +
                "\npeso:" + peso +
                "\n------------------------------------------------------------------\n";
    }
}
