package co.edu.unicesar.practicaFinal.negocio;


import co.edu.unicesar.practicaFinal.data.ArchivoDeObjetos;
import co.edu.unicesar.practicaFinal.data.ArchivoDeTexto;
import co.edu.unicesar.practicaFinal.data.IAccesoDatos;
import co.edu.unicesar.practicaFinal.dominio.Publicacion;


import java.io.IOException;
import java.util.List;

public class RegistroPublicacion {
    private IAccesoDatos datos;
    private final static RegistroPublicacion instance = new RegistroPublicacion();

    public static RegistroPublicacion getInstance() {
        return instance;
    }

    public RegistroPublicacion() {
        this.datos = new ArchivoDeTexto();
    }

    public void insertar(Publicacion publicacion) throws IOException {

        datos.insertarPublicacion(publicacion);
    }

    public List<Publicacion> leer() {
        try {
            return datos.leerPublicaciones();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Publicacion buscarPor(String buscar) {
        try {
            return datos.buscarPublicacion(buscar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void  eliminar(String buscar){
        try {
            datos.eliminarPublicacion(buscar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
