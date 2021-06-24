package co.edu.unicesar.practicaFinal.view.Graficas;

import co.edu.unicesar.practicaFinal.dominio.Libro;
import co.edu.unicesar.practicaFinal.negocio.RegistroPublicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaRegistroLibro extends JDialog {
    private JLabel lISBN, lTitulo, lAño, lAutor, lCosto, lNpaginas, lEdicion;
    private JTextField tTipo, tISBN, tTitulo, tAño, tAutor, tCosto, tNpaginas, tEdicion;
    private JButton bGuardar, bCancelar, bNuevo, bBuscar, bEliminar;
    private JPanel panelDatos, panelBotones;
    private Container contenedor;
    private RegistroPublicacion gestor;

    public VentanaRegistroLibro(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestor = new RegistroPublicacion();
        this.setTitle("Formulario Registro de Libro - V1");
        this.setSize(700, 400);
        this.iniciarComponentes();
        //this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.iniciarPanelDatos();
        this.iniciarPanelBotones();
    }

    public void iniciarPanelDatos() {
        this.panelDatos = new JPanel();
        this.panelDatos.setLayout(new GridLayout(8, 2, 5, 5));

        this.lISBN = new JLabel("ISBN: ");
        this.lTitulo = new JLabel("Titulo: ");
        this.lAño = new JLabel("Año: ");
        this.lAutor = new JLabel("Autor: ");
        this.lNpaginas = new JLabel("Numero de Paginas: ");
        this.lCosto = new JLabel("Costo: ");
        this.lEdicion = new JLabel("Edicion: ");

        this.tTipo = new JTextField("Libro");
        this.tISBN = new JTextField(null);
        this.tTitulo = new JTextField(null);
        this.tAño = new JTextField(null);
        this.tAutor = new JTextField(null);
        this.tNpaginas = new JTextField(null);
        this.tCosto = new JTextField(null);
        this.tEdicion = new JTextField(null);

        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new ClickBotonGuardar());
        this.bGuardar.setEnabled(false);
        this.bCancelar = new JButton("Cancelar");
        this.bCancelar.setEnabled(false);

        this.panelDatos.add(this.lISBN);
        this.panelDatos.add(this.tISBN);

        this.panelDatos.add(this.lTitulo);
        this.panelDatos.add(this.tTitulo);

        this.panelDatos.add(this.lAño);
        this.panelDatos.add(this.tAño);

        this.panelDatos.add(this.lAutor);
        this.panelDatos.add(this.tAutor);

        this.panelDatos.add(this.lNpaginas);
        this.panelDatos.add(this.tNpaginas);

        this.panelDatos.add(this.lCosto);
        this.panelDatos.add(this.tCosto);

        this.panelDatos.add(this.lEdicion);
        this.panelDatos.add(this.tEdicion);

        this.panelDatos.add(this.bGuardar);
        this.panelDatos.add(this.bCancelar);

        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);
    }

    public void iniciarPanelBotones() {
        this.panelBotones = new JPanel();
        this.panelBotones.setLayout(new GridLayout(3,1, 5,5));

        this.bNuevo = new JButton("Nuevo");
        this.bNuevo.addActionListener(new clickBotonNuevo());

        this.bBuscar = new JButton("Buscar");
        this.bBuscar.setEnabled(false);
        this.bEliminar= new JButton("Eliminar");
        this.bEliminar.setEnabled(false);

        this.panelBotones.add(this.bNuevo);
        this.panelBotones.add(this.bBuscar);
        this.panelBotones.add(this.bEliminar);

        JPanel panel = new JPanel();
        panel.add(this.panelBotones);

        this.contenedor.add(panel, BorderLayout.EAST);
    }

    public void activarComponentes() {
        this.tISBN.setEnabled(true);
        this.bGuardar.setEnabled(true);
        this.bCancelar.setEnabled(true);
        this.bBuscar.setEnabled(true);
        this.bEliminar.setEnabled(true);
        this.tISBN.grabFocus();
    }

    public Libro leerComponentes() {
        String tipo = this.tTipo.getText();
        String ISBN = this.tISBN.getText();
        String titulo = this.tTitulo.getText();
        int año = Integer.parseInt(this.tAño.getText());
        String autor = this.tAutor.getText();
        double costo = Double.parseDouble(this.tCosto.getText());
        int nPaginas = Integer.parseInt(this.tNpaginas.getText());
        int edicion = Integer.parseInt(this.tEdicion.getText());
        Libro libro = new Libro(tipo,ISBN,titulo,año,autor,costo,nPaginas,edicion);
        return libro;
    }


    public void guardarLibro(){
        try{
            Libro libro = this.leerComponentes();
            this.gestor.insertar(libro);
            this.ventanaMsg("Datos guardados con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        }catch(IOException | NullPointerException | NumberFormatException ioe){
            this.ventanaMsg(ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ventanaMsg(String msg, String titulo, int tipo){
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }


    class clickBotonNuevo implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            activarComponentes();
        }
    }

    class ClickBotonGuardar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            guardarLibro();
        }

    }
}
