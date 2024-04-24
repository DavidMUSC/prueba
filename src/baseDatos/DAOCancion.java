package baseDatos;

import aplicacion.Cancion;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCancion extends abstractDAO {
    public DAOCancion(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public List<Cancion> buscarCanciones(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmCancion = null;
        ResultSet rsCancion;
        List<Cancion> cancionesEncontradas = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM CANCION WHERE nombre LIKE ?";
        try {
            stmCancion = con.prepareStatement(sql);
            stmCancion.setString(1, "%" + terminoBusqueda + "%");

            rsCancion = stmCancion.executeQuery();
            while (rsCancion.next()) {
                String nombre = rsCancion.getString("nombre");
                int idCancion = rsCancion.getInt("IDCancion");
                String duracion = rsCancion.getString("duracion");
                String idioma = rsCancion.getString("idioma");
                String nombreGenero = rsCancion.getString("nombreGenero");
                boolean letra = rsCancion.getBoolean("letra");
                int visualizaciones = rsCancion.getInt("visualizaciones");
                int IDAlbum = rsCancion.getInt("IDAlbum");
                boolean explicito = rsCancion.getBoolean("explicito");

                Cancion cancion = new Cancion(nombre, idCancion, duracion, idioma, nombreGenero, letra, visualizaciones, IDAlbum, explicito);
                cancionesEncontradas.add(cancion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCancion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return cancionesEncontradas;
    }

    public String obtenerArtistaDeCancion(String nombreCancion) {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        String nombreArtista = null;

        con = this.getConexion();

        String sql = "SELECT a.nombreArtistico " +
                "FROM ARTISTA a " +
                "INNER JOIN COMPONER c ON a.nombre = c.IDArtista " +
                "INNER JOIN CANCION ca ON c.IDAlbum = ca.IDAlbum " +
                "WHERE ca.nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, nombreCancion);

            rsArtista = stmArtista.executeQuery();
            if (rsArtista.next()) {
                nombreArtista = rsArtista.getString("nombreArtistico");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmArtista.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return nombreArtista;
    }


}

