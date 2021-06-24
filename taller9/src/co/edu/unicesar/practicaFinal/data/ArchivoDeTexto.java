package co.edu.unicesar.practicaFinal.data;

import co.edu.unicesar.practicaFinal.dominio.AudioLibro;
import co.edu.unicesar.practicaFinal.dominio.Libro;
import co.edu.unicesar.practicaFinal.dominio.Publicacion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoDeTexto implements IAccesoDatos {
    private File archivo;
    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public ArchivoDeTexto() {
        this.archivo = new File("Pulicaciones.dat");
    }

    public ArchivoDeTexto(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }


    @Override
    public void insertarPublicacion(Publicacion publicacion) throws IOException {
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.archivo, true); // modo edicion
            pw = new PrintWriter(this.modoEscritura);
            pw.println(publicacion.getDataText());
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (pw != null)
                pw.close();
            this.modoEscritura.close();
        }
    }

    private Publicacion crearLibro(String linea) {

        String datos[] = linea.split(";");
        Libro libro = new Libro();

        if (datos[7].equalsIgnoreCase("Libro")) {
            libro.setISBN(datos[0]);
            libro.setTitulo(datos[1]);
            libro.setAño(Integer.parseInt(datos[2]));
            libro.setAutor(datos[3]);
            libro.setCosto(Double.parseDouble(datos[4]));
            libro.setnPaginas(Integer.parseInt(datos[5]));
            libro.setEdicion(Integer.parseInt(datos[6]));
            return libro;
        }
        AudioLibro audioLibro = new AudioLibro();
        audioLibro.setISBN(datos[0]);
        audioLibro.setTitulo(datos[1]);
        audioLibro.setAño(Integer.parseInt(datos[2]));
        audioLibro.setAutor(datos[3]);
        audioLibro.setCosto(Double.parseDouble(datos[4]));
        audioLibro.setDuracion(Double.parseDouble(datos[5]));
        audioLibro.setFormato(datos[6]);
        audioLibro.setPeso(Double.parseDouble(datos[7]));
        return audioLibro;

    }

    @Override
    public List<Publicacion> leerPublicaciones() throws IOException {
        List<Publicacion> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Publicacion publicacion = this.crearLibro(linea);
                listado.add(publicacion);
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
    }


    @Override
    public Publicacion buscarPublicacion(String buscar) throws IOException {
        Publicacion encontrado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Publicacion publicacion = this.crearLibro(linea);
                if (publicacion.getISBN().equalsIgnoreCase(buscar)) {
                    encontrado = publicacion;
                    break;
                }
            }
            return encontrado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null)
                this.modoLectura.close();
        }
    }

    private void renombrarArchivo(File nvoArchivo) throws IOException {
        // se crea el archivo temporal si no existe
        if (!nvoArchivo.exists())
            nvoArchivo.createNewFile();

        //se elimina el archivo original
        if (!this.archivo.delete()) {
            throw new IOException("No fue posible eliminar el archivo original");
        }

        //se renombra el archivo temporal
        if (!nvoArchivo.renameTo(this.archivo)) {
            throw new IOException("No fue posible renombrar el archivo temporal");
        }


    }

    @Override
    public void eliminarPublicacion(String buscar) throws IOException {
        try {
            this.modoLectura = new Scanner(this.archivo);
            ArchivoDeTexto archivoTemporal = new ArchivoDeTexto("Temporal.dat");
            while(this.modoLectura.hasNext()){
                String linea = this.modoLectura.nextLine();
                Publicacion publicacion = this.crearLibro(linea);
                if(!publicacion.getISBN().equalsIgnoreCase(buscar)){// eliminar
                    archivoTemporal.insertarPublicacion(publicacion);
                }
            }
            this.modoLectura.close();
            this.renombrarArchivo(archivoTemporal.archivo);
        } catch (IOException ioe) {
            throw ioe;
        }
        finally{
            this.modoLectura.close();
        }

    }

}
