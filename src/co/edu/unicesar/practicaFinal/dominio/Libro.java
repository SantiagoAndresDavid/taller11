package co.edu.unicesar.practicaFinal.dominio;


import java.io.Serializable;

public class Libro extends Publicacion implements Serializable {
    private String tipo = "Libro";
    private int nPaginas;
    private int edicion;

    public Libro() {
    }

    public Libro(String tipo,
                 String ISBN,
                 String titulo,
                 int año,
                 String autor,
                 double costo,
                 int nPaginas,
                 int edicion) {

        super(ISBN, titulo, año, autor, costo);
        this.nPaginas = nPaginas;
        this.edicion = edicion;
        this.tipo = tipo;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataText() {
        return super.getDataText() + ";"
                + this.nPaginas + ";"
                + this.edicion+";"
                +this.tipo;
    }


    public String getInfo() {
        return super.getInfo() +
                "\nNumero de paginas: " + nPaginas +
                "\nEdicion: " + edicion +
                "\n---------------------------------------------------------------------------------------------------";
    }


    @Override
    public String toString() {
        return  super.toString()+
                "\ntipo: " + tipo +
                "\nNumero de Paginas:" + nPaginas +
                "\nedicion:" + edicion +
                "\n----------------------------------------------------\n";
    }
}
