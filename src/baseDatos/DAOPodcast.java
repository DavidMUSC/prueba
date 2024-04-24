package baseDatos;

import aplicacion.Podcast;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOPodcast extends abstractDAO {
    public DAOPodcast(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public List<Podcast> buscarPodcasts(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmPodcast = null;
        ResultSet rsPodcast;
        List<Podcast> podcastsEncontrados = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM PODCAST WHERE nombre LIKE ?";
        try {
            stmPodcast = con.prepareStatement(sql);
            stmPodcast.setString(1, "%" + terminoBusqueda + "%");

            rsPodcast = stmPodcast.executeQuery();
            while (rsPodcast.next()) {
                int idPodcast = rsPodcast.getInt("IDPodcast");
                String nombre = rsPodcast.getString("nombre");

                Podcast podcast = new Podcast(idPodcast, nombre);
                // Agregar más campos al constructor de Podcast si es necesario

                podcastsEncontrados.add(podcast);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPodcast.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return podcastsEncontrados;
    }

    public String obtenerArtistaDePodcast(String nombrePodcast) {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        String nombreArtista = null;

        con = this.getConexion();

        String sql = "SELECT a.nombreArtistico " +
                "FROM ARTISTA a " +
                "INNER JOIN PARTICIPARPODCAST pp ON a.nombre = pp.IDArtista " +
                "INNER JOIN PODCAST p ON pp.IDPodcast = p.IDPodcast " +
                "WHERE p.nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, nombrePodcast);

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