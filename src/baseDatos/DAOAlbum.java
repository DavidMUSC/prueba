package baseDatos;

import aplicacion.Album;

import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOAlbum extends abstractDAO {
    public DAOAlbum(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public List<Album> buscarAlbumes(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmAlbum = null;
        ResultSet rsAlbum;
        List<Album> albumesEncontrados = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM ALBUM WHERE nombre LIKE ?";
        try {
            stmAlbum = con.prepareStatement(sql);
            stmAlbum.setString(1, "%" + terminoBusqueda + "%");

            rsAlbum = stmAlbum.executeQuery();
            while (rsAlbum.next()) {
                int idAlbum = rsAlbum.getInt("IDAlbum");
                String nombre = rsAlbum.getString("nombre");
                String tipo = rsAlbum.getString("tipo");
                int añoLanzamiento = rsAlbum.getInt("añoLanzamiento");
                int idDiscografica = rsAlbum.getInt("IDDiscografica"); // Suponiendo que hay un campo IDDiscografica en la tabla ALBUM

                Album album = new Album(idAlbum, nombre, tipo, añoLanzamiento, idDiscografica);
                albumesEncontrados.add(album);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmAlbum.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return albumesEncontrados;
    }

    public String obtenerArtistaDeAlbum(String nombreAlbum) {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        String nombreArtista = null;

        con = this.getConexion();

        String sql = "SELECT a.nombreArtistico " +
                "FROM ARTISTA a " +
                "INNER JOIN COMPONER c ON a.nombre = c.IDArtista " +
                "INNER JOIN ALBUM al ON c.IDAlbum = al.IDAlbum " +
                "WHERE al.nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, nombreAlbum);

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