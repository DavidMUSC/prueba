package baseDatos;

import aplicacion.Artista;
import aplicacion.Oyente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCancion extends abstractDAO {
    public DAOCancion(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }



}

