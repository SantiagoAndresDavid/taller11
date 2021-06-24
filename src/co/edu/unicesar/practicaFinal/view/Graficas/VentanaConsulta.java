package co.edu.unicesar.practicaFinal.view.Graficas;


import co.edu.unicesar.practicaFinal.dominio.AudioLibro;
import co.edu.unicesar.practicaFinal.dominio.Libro;
import co.edu.unicesar.practicaFinal.dominio.Publicacion;
import co.edu.unicesar.practicaFinal.negocio.RegistroPublicacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaConsulta extends JDialog {
    private Container contenedor;
    private JPanel panelFiltro;
    private JScrollPane panelResultado;
    private JLabel lFiltro;
    private JTextField tFiltro;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton bBuscar;
    private String titulos[] = {"ISBN", "Titulo", "Año", "autor", "costo"};
    private RegistroPublicacion gestor;


    public VentanaConsulta(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestor = new RegistroPublicacion();
        this.setTitle("Consulta de Publicaciones - V1");
        this.iniciarComponentes();
        this.pack();
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void activarComponentes() {
        this.bBuscar.setEnabled(true);
    }

    public void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.actualizarTabla();
        this.activarComponentes();
    }

    public void iniciarPanelFiltro() {
        this.lFiltro = new JLabel("Ingrese el ISBN: ");
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.tFiltro = new JTextField(10);
        this.bBuscar = new JButton("Buscar");
        this.bBuscar.addActionListener(new ClickBotonGuardar());

        this.panelFiltro.add(this.lFiltro);
        this.panelFiltro.add(this.tFiltro);
        this.panelFiltro.add(this.bBuscar);

        this.contenedor.add(this.panelFiltro, BorderLayout.NORTH);
    }

    public void iniciarPanelResultado() {
        this.panelResultado = new JScrollPane();
        this.tabla = new JTable();
        this.modelo = new DefaultTableModel(null, this.titulos);
        this.tabla.setModel(modelo);
        this.panelResultado.setViewportView(this.tabla);

        this.contenedor.add(this.panelResultado, BorderLayout.CENTER);

    }

    public void actualizarTabla() {
        List<Publicacion> listado = this.gestor.leer();
        this.modelo.setNumRows(0);
        for (Publicacion publicacion : listado) {
            String linea[] = {publicacion.getISBN(), publicacion.getTitulo(), "" + publicacion.getAño(),
                    publicacion.getAutor(), "" + publicacion.getCosto()};
            this.modelo.addRow(linea);
        }

    }

    public void buscar() {
        try {
            String filtro = this.tFiltro.getText();
            new PresentarPublicacion(null, true,filtro);
        } catch (NumberFormatException e) {
            this.ventanaMsg(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    class ClickBotonGuardar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            buscar();
        }

    }
}
