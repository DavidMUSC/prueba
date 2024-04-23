package baseDatos;

import java.sql.Connection;

public class DAOArtistas extends abstractDAO {
    public DAOArtistas (Connection conexion, aplicacion.fachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

}
