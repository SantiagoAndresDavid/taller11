package co.edu.unicesar.practicaFinal.data;

import co.edu.unicesar.practicaFinal.dominio.Publicacion;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class ArchivoDeObjetos implements IAccesoDatos{

    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    public ArchivoDeObjetos(String name) {
        this.archivo = new File(name);
    }

    public ArchivoDeObjetos() {
        this("NominaJugadores.obj");
    }

    private void guardar(ArrayAccesoDatos lista) throws IOException {
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo, false);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(lista);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }
    }

    private ArrayAccesoDatos leer() throws IOException {
        ArrayAccesoDatos lista;
        ObjectInputStream ois = null;

        if (this.archivo.exists()) {
            try {
                this.aLectura = new FileInputStream(this.archivo);
                ois = new ObjectInputStream(this.aLectura);
                lista = (ArrayAccesoDatos) ois.readObject();
                return lista;
            } catch (IOException ioe) {
                throw ioe;
            } catch (ClassNotFoundException ex) {
                throw new IOException("La clase ArrayAccesoDatos  No existe");
            } finally {
                if (ois != null) {
                    ois.close();
                }
                if (this.aLectura != null) {
                    this.aLectura.close();
                }
            }
        }
        else{
            lista = new ArrayAccesoDatos();
            return lista;
        }
    }


    @Override
    public void insertarPublicacion(Publicacion publicacion) throws IOException {
        ArrayAccesoDatos lista = this.leer();
        lista.insertarPublicacion(publicacion);
        this.guardar(lista);
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws IOException {
        ArrayAccesoDatos lista = this.leer();
        return lista.leerPublicaciones();
    }

    @Override
    public Publicacion buscarPublicacion(String buscar) throws IOException {
        ArrayAccesoDatos lista = this.leer();
        return lista.buscarPublicacion(buscar);
    }

    @Override
    public void eliminarPublicacion(String buscar) throws IOException {
        ArrayAccesoDatos lista = this.leer();
        for (Publicacion publicacion : lista.listaPublicacion) {
            if (publicacion.getISBN().equals(buscar)) {
                lista.listaPublicacion.remove(publicacion);
                return;
            }
        }
    }
}
