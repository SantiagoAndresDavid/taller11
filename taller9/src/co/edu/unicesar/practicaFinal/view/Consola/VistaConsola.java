package co.edu.unicesar.practicaFinal.view.Consola;

import co.edu.unicesar.practicaFinal.dominio.AudioLibro;
import co.edu.unicesar.practicaFinal.dominio.Libro;
import co.edu.unicesar.practicaFinal.dominio.Publicacion;
import co.edu.unicesar.practicaFinal.negocio.RegistroPublicacion;

import java.io.IOException;
import java.util.Scanner;

public class VistaConsola {
    private final Menus menus = new Menus();
    Scanner scanner = new Scanner(System.in);
    private final RegistroPublicacion registroPublicacion = new RegistroPublicacion();

    public void ejecutarMenus() {
        switch (menus.opcionesPublicaciones()) {
            case 1:
                try {
                    Publicacion publicacion = menus.llerar();
                    registroPublicacion.insertar(publicacion);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ejecutarMenus();
                break;
            case 2:
                menus.mostrarProcesos(registroPublicacion.buscarPor(menus.ingresarBuscar()));
                ejecutarMenus();
                break;
            case 3:
                System.out.println(registroPublicacion.leer());
                ejecutarMenus();
                break;
            case 4:
                registroPublicacion.eliminar(menus.ingresarBuscar());
                ejecutarMenus();
                break;
            default:
                System.out.println("error opcion ");
        }
    }
}