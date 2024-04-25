package baseDatos;

import aplicacion.Discografica;

import java.sql.*;
import java.util.*;

public class DAODiscografica extends abstractDAO {
    public DAODiscografica(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Discografica buscarDiscografica(String nombreDiscografica) {
        Connection con = null;
        PreparedStatement stmDiscografica = null;
        ResultSet rsDiscografica = null;

        try {
            con = this.getConexion();

            // Consulta SQL para buscar una discográfica por su nombre
            String sqlBuscarDiscografica = "SELECT * FROM DISCOGRAFICA WHERE nombre = ?";

            // Preparar la consulta
            stmDiscografica = con.prepareStatement(sqlBuscarDiscografica);
            stmDiscografica.setString(1, nombreDiscografica); // Asignar el parámetro nombre

            // Ejecutar la consulta
            rsDiscografica = stmDiscografica.executeQuery();

            // Verificar si se encontró alguna discográfica
            if (rsDiscografica.next()) {
                // Construir y devolver el objeto Discografica
                int IDDiscografica = rsDiscografica.getInt("IDDiscografica");
                String nombre = rsDiscografica.getString("nombre");
                String pais = rsDiscografica.getString("pais");
                return new Discografica(IDDiscografica, nombre, pais);
            } else {
                // Si no se encuentra ninguna discográfica, devolver null
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            return null; // Manejar la excepción y devolver null en caso de error
        } finally {
            // Cerrar recursos
            try {
                if (rsDiscografica != null) {
                    rsDiscografica.close();
                }
                if (stmDiscografica != null) {
                    stmDiscografica.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

}
