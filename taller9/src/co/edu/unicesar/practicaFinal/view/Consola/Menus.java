package co.edu.unicesar.practicaFinal.view.Consola;

import co.edu.unicesar.practicaFinal.dominio.AudioLibro;
import co.edu.unicesar.practicaFinal.dominio.Libro;
import co.edu.unicesar.practicaFinal.dominio.Publicacion;
import java.util.Scanner;

public class Menus {
    Scanner scanner = new Scanner(System.in);

    public int opcionesPublicaciones(){
        System.out.println("------------------- Menu principal -------------------");
        System.out.println("1. ingresar una publicacion");
        System.out.println("2. buscar por el numero de ISBN");
        System.out.println("3. imprimir todas las publicaciones");
        System.out.println("4. Eliminar una publicacion");
        System.out.println("ingrese una opcion");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }


    public int opcionRegistro(){
        System.out.println("Ingrese que tipo de libro desea ingresar");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("1. Libro");
        System.out.println("2. AudioLibro");
        System.out.println("3. Atras");
        System.out.println("-----------------------------------------------------------------------------------------");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public Publicacion llerar(){
        switch (opcionRegistro()) {
            case 1:
                Libro libro = new Libro();
                libro.setTipo("Libro");
                System.out.println("Ingrese el ISBN");
                libro.setISBN(scanner.nextLine());
                System.out.println("Ingrese el titulo");
                libro.setTitulo(scanner.nextLine());
                System.out.println("Ingrese el Año de publicacion");
                libro.setAño(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Ingrese el Autor");
                libro.setAutor(scanner.nextLine());
                System.out.println("Ingrese el costo");
                libro.setCosto(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Ingrese el numero de paginas");
                libro.setnPaginas(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Ingrese la edicion");
                libro.setEdicion(scanner.nextInt());
                scanner.nextLine();
                return libro;
            case 2:
                AudioLibro audioLibro = new AudioLibro();
                audioLibro.setTipo("AudioLibro");
                System.out.println("Ingrese el ISBN");
                audioLibro.setISBN(scanner.nextLine());
                System.out.println("Ingrese el titulo");
                audioLibro.setTitulo(scanner.nextLine());
                System.out.println("Ingrese el año de publicacion");
                audioLibro.setAño(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Ingrese el autor ");
                audioLibro.setAutor(scanner.nextLine());
                System.out.println("Ingrese el costo");
                audioLibro.setCosto(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Ingrese la duracion");
                audioLibro.setDuracion(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Ingrese el formato");
                audioLibro.setFormato(scanner.nextLine());
                System.out.println("Ingrese el peso");
                audioLibro.setPeso(scanner.nextDouble());
                scanner.nextLine();
                return audioLibro;
            case 3:

            default:
                System.out.println("Opcion incorrecta");
        }
        return null;
    }

    public String ingresarBuscar(){
        System.out.println("Ingrese el ISBN");
        String buscar = scanner.nextLine();
        return buscar;
    }

    public void mostrarProcesos(Publicacion publicacion){
        System.out.println(publicacion.getInfo());
    }

    

}
