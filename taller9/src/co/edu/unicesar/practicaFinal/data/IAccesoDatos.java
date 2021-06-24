package co.edu.unicesar.practicaFinal.data;

import co.edu.unicesar.practicaFinal.dominio.Publicacion;

import java.io.IOException;
import java.util.List;

public interface IAccesoDatos {
    void insertarPublicacion(Publicacion publicacion) throws IOException;
    List <Publicacion> leerPublicaciones()throws IOException;
    Publicacion buscarPublicacion(String buscar)throws IOException;
    void eliminarPublicacion(String buscar)throws IOException;

}
