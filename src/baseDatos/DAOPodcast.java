package baseDatos;

import aplicacion.Podcast;

import java.sql.*;
import java.util.*;

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
        int i = 23;
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

    public void publicarPodcast(Podcast podcast) throws SQLException {
        Connection con = null;
        PreparedStatement stmPodcast = null;
        try {
            con = this.getConexion();
            // Consulta para obtener el último ID de podcast
            String sqlUltimoIDPodcast = "SELECT MAX(IDPodcast) FROM PODCAST";
            // Obtener el último ID de podcast
            int ultimoIDPodcast = 0;
            Statement stmtUltimoIDPodcast = con.createStatement();
            ResultSet rsUltimoIDPodcast = stmtUltimoIDPodcast.executeQuery(sqlUltimoIDPodcast);
            if (rsUltimoIDPodcast.next()) {
                ultimoIDPodcast = rsUltimoIDPodcast.getInt(1);
            }
            // Incrementar el último ID de podcast para obtener un nuevo ID único
            int nuevoIDPodcast = ultimoIDPodcast + 1;
            // Consulta para insertar el podcast
            String sqlInsertPodcast = "INSERT INTO PODCAST (nombre, IDPodcast) " +
                    "VALUES (?, ?)";
            // Insertar el podcast
            stmPodcast = con.prepareStatement(sqlInsertPodcast);
            stmPodcast.setString(1, podcast.getNombre());
            stmPodcast.setInt(2, nuevoIDPodcast);
            stmPodcast.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmPodcast != null) {
                    stmPodcast.close();
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