package co.edu.unicesar.practicaFinal.data;

import co.edu.unicesar.practicaFinal.dominio.Publicacion;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArrayAccesoDatos implements IAccesoDatos, Serializable {
    List<Publicacion> listaPublicacion = new ArrayList<>();

    public List<Publicacion> getListaPublicacion() {
        return listaPublicacion;
    }

    public void setListaPublicacion() {
        this.listaPublicacion = listaPublicacion;
    }

    @Override
    public void insertarPublicacion(Publicacion publicacion) {
        listaPublicacion.add(publicacion);
    }


    @Override
    public List<Publicacion> leerPublicaciones() {
        return this.listaPublicacion;
    }

    @Override
    public Publicacion buscarPublicacion(String buscar) {
        for (Publicacion publicacion : listaPublicacion) {
            if (publicacion.getISBN().equals(buscar)) {
                return publicacion;
            }
        }
        return null;
    }

    @Override
    public void eliminarPublicacion(String buscar) {
        for (Publicacion publicacion : listaPublicacion) {
            if (publicacion.getISBN().equals(buscar)) {
                listaPublicacion.remove(publicacion);
                return;
            }
        }
    }


    @Override
    public String toString() {
        return "ArrayAccesoDatos{" +
                "listaPublicacion=" + listaPublicacion +
                '}';
    }


}
