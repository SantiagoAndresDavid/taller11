package co.edu.unicesar.practicaFinal.view.Graficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem mRegistro, mConsulta, mEliminar;
    private JPanel panelImg;
    private JLabel lImg;

    public VentanaPrincipal() {
        this("Registro de Jugadores - V 1.0");
    }

    public VentanaPrincipal(String string) {
        super(string);
        this.iniciarComponentes();

    }

    public void iniciarComponentes() {
        Image img = new ImageIcon("src/Imagenes/appImg.png").getImage();
        this.setIconImage(img);
        this.iniciarBarraMenu();
        this.crearPanelImg();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void iniciarBarraMenu() {
        this.barraMenu = new JMenuBar();

        this.menu = new JMenu("Operaciones");
        this.menu.setIcon(new ImageIcon(""));

        this.mRegistro = new JMenuItem("Registro");
        this.mRegistro.setIcon(new ImageIcon("C:\\Users\\santi\\Desktop\\taller11\\taller9\\src\\co\\edu\\unicesar\\practicaFinal\\view\\Graficas\\imagenes\\agregar-archivo.png"));
        this.mRegistro.addActionListener(this);

        this.mConsulta = new JMenuItem("Consulta");
        this.mConsulta.setIcon(new ImageIcon("C:\\Users\\santi\\Desktop\\taller11\\taller9\\src\\co\\edu\\unicesar\\practicaFinal\\view\\Graficas\\imagenes\\consulta.png"));
        this.mConsulta.addActionListener(this);

        this.mEliminar = new JMenuItem("Eliminar");
        this.mEliminar.setIcon(new ImageIcon("C:\\Users\\santi\\Desktop\\taller11\\taller9\\src\\co\\edu\\unicesar\\practicaFinal\\view\\Graficas\\imagenes\\compartimiento.png"));
        this.mEliminar.addActionListener(this);

        this.menu.add(this.mRegistro);
        this.menu.add(this.mConsulta);
        this.menu.add(this.mEliminar);

        this.barraMenu.add(this.menu);

        this.setJMenuBar(this.barraMenu);
    }

    public void crearPanelImg() {
        this.panelImg = new JPanel();
        this.panelImg.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.lImg = new JLabel();
        this.lImg.setIcon(new ImageIcon("C:\\Users\\santi\\Desktop\\taller11\\taller9\\src\\co\\edu\\unicesar\\practicaFinal\\view\\Graficas\\imagenes\\Universidad_Popular_del_Cesar.png"));
        this.panelImg.add(this.lImg);
        this.panelImg.setBackground(Color.WHITE);
        this.getContentPane().setBackground(Color.WHITE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(this.panelImg, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.mRegistro) {
            String opcion = JOptionPane.showInputDialog("\t Que tipo de libro desea ingresar\n" + "\t1.Libro\n" + "\t2.Audio Libro");
            switch (opcion) {
                case "1":
                    VentanaRegistroLibro registroLibro = new VentanaRegistroLibro(this, true);
                    break;
                case "2":
                    VentanaRegistroAudioLibro registroAudioLibro = new VentanaRegistroAudioLibro(this, true);
                    break;

            }

        }
        if(e.getSource()==this.mConsulta){
            VentanaConsulta consulta = new VentanaConsulta(this, true);
        }

        if(e.getSource()==this.mEliminar){
            VentanaEliminar eliminar = new VentanaEliminar(this, true);
        }

    }



}
