package co.edu.unicesar.practicaFinal.view.Graficas;

import co.edu.unicesar.practicaFinal.dominio.AudioLibro;
import co.edu.unicesar.practicaFinal.dominio.Libro;
import co.edu.unicesar.practicaFinal.dominio.Publicacion;
import co.edu.unicesar.practicaFinal.negocio.RegistroPublicacion;

import javax.swing.*;
import java.awt.*;

public class PresentarPublicacion extends JDialog {
    private JLabel lISBN, lTitulo, lAño, lAutor, lCosto, lDuracion, lFormato, lPeso, lNpaginas, lEdicion, lrISBN, lrTitulo, lrAño, lrAutor, lrCosto, lrDuracion, lrFormato, lrPeso, lrNpaginas, lrEdicion;
    private JPanel panelDatos;
    private Container contenedor;
    private RegistroPublicacion gestor;

    public PresentarPublicacion(JFrame frame, boolean bln, String filtro) {
        super(frame, bln);
        this.gestor = new RegistroPublicacion();
        this.setTitle("Mostrar - V1");
        this.setSize(300, 300);
        Publicacion publicacion = this.gestor.buscarPor(filtro);
        iniciarComponentes(publicacion);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void iniciarComponentes(Publicacion publicacion) {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        if (publicacion instanceof Libro) {
            Libro libro = (Libro) publicacion;
            iniciarPanelLirbos(libro);
        } else if (publicacion instanceof AudioLibro) {
            AudioLibro audioLibro = (AudioLibro) publicacion;
            iniciarPanelAudiolibro(audioLibro);
        }

    }

    public void iniciarPanelLirbos(Libro libro) {
        this.panelDatos = new JPanel();
        this.panelDatos.setLayout(new GridLayout(8, 2, 5, 5));

        this.lISBN = new JLabel("ISBN: ");
        this.lTitulo = new JLabel("Titulo: ");
        this.lAño = new JLabel("Año: ");
        this.lAutor = new JLabel("Autor: ");
        this.lNpaginas = new JLabel("Numero de Paginas: ");
        this.lCosto = new JLabel("Costo: ");
        this.lEdicion = new JLabel("Edicion: ");

        this.lrISBN = new JLabel(libro.getISBN());
        this.lrTitulo = new JLabel(libro.getTitulo());
        this.lrAño = new JLabel(String.valueOf(libro.getAño()));
        this.lrAutor = new JLabel(libro.getAutor());
        this.lrNpaginas = new JLabel(String.valueOf(libro.getnPaginas()));
        this.lrCosto = new JLabel(String.valueOf(libro.getCosto()));
        this.lrEdicion = new JLabel(String.valueOf(libro.getEdicion()));

        this.panelDatos.add(this.lISBN);
        this.panelDatos.add(this.lrISBN);
        this.panelDatos.add(this.lTitulo);
        this.panelDatos.add(this.lrTitulo);
        this.panelDatos.add(this.lAño);
        this.panelDatos.add(this.lrAño);
        this.panelDatos.add(this.lAutor);
        this.panelDatos.add(this.lrAutor);
        this.panelDatos.add(this.lNpaginas);
        this.panelDatos.add(this.lrNpaginas);
        this.panelDatos.add(this.lCosto);
        this.panelDatos.add(this.lrCosto);
        this.panelDatos.add(this.lEdicion);
        this.panelDatos.add(this.lrEdicion);

        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);
    }

    public void iniciarPanelAudiolibro(AudioLibro audioLibro) {
        this.panelDatos = new JPanel();
        this.panelDatos.setLayout(new GridLayout(8, 2, 5, 5));

        this.lISBN = new JLabel("ISBN: ");
        this.lTitulo = new JLabel("Titulo: ");
        this.lAño = new JLabel("Año: ");
        this.lAutor = new JLabel("Autor: ");
        this.lCosto = new JLabel("Costo: ");
        this.lDuracion = new JLabel("Duracion: ");
        this.lFormato = new JLabel("Formato: ");
        this.lPeso = new JLabel("Peso: ");

        this.lrISBN = new JLabel(audioLibro.getISBN());
        this.lrTitulo = new JLabel(audioLibro.getTitulo());
        this.lrAño = new JLabel(String.valueOf(audioLibro.getAño()));
        this.lrAutor = new JLabel(audioLibro.getAutor());
        this.lrCosto = new JLabel(String.valueOf(audioLibro.getCosto()));
        this.lrDuracion = new JLabel(String.valueOf(audioLibro.getDuracion()));
        this.lrFormato = new JLabel(audioLibro.getFormato());
        this.lrPeso = new JLabel(String.valueOf(audioLibro.getPeso()));


        this.panelDatos.add(this.lISBN);
        this.panelDatos.add(this.lrISBN);
        this.panelDatos.add(this.lTitulo);
        this.panelDatos.add(this.lrTitulo);
        this.panelDatos.add(this.lAño);
        this.panelDatos.add(this.lrAño);
        this.panelDatos.add(this.lAutor);
        this.panelDatos.add(this.lrAutor);
        this.panelDatos.add(this.lCosto);
        this.panelDatos.add(this.lrCosto);
        this.panelDatos.add(this.lDuracion);
        this.panelDatos.add(this.lrDuracion);
        this.panelDatos.add(this.lFormato);
        this.panelDatos.add(this.lrFormato);
        this.panelDatos.add(this.lPeso);
        this.panelDatos.add(this.lrPeso);
        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);
    }

}
