package baseDatos;

import aplicacion.Cancion;
import aplicacion.Artista;
import java.sql.*;
import java.util.*;

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

        String sql = "SELECT * FROM CANCION WHERE nombre like ?";
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
    public List<Cancion> buscarCancionesEn(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmCancion = null;
        ResultSet rsCancion;
        List<Cancion> cancionesEncontradas = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM CANCION WHERE nombre = ?";
        try {
            stmCancion = con.prepareStatement(sql);
            stmCancion.setString(1, terminoBusqueda);

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

    public List<Artista> obtenerArtistasDeCancion(String nombreCancion) {
        Connection con;
        PreparedStatement stmArtista = null;
        ResultSet rsArtista;
        List<Artista>  artistas = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT a.* " +
                "FROM ARTISTA a " +
                "INNER JOIN COMPONER c ON a.nombre = c.IDArtista " +
                "INNER JOIN CANCION ca ON c.IDAlbum = ca.IDAlbum " +
                "WHERE ca.nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, nombreCancion);

            rsArtista = stmArtista.executeQuery();
            while (rsArtista.next()) {
                artistas.add(new Artista(rsArtista.getString("nombre"),rsArtista.getString("contraseña"),
                        rsArtista.getString("email"),rsArtista.getDate("fechaNacimiento"),
                        rsArtista.getString("nombreArtistico"),rsArtista.getString("paisNacimiento")));
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
        return artistas;
    }


    public void publicarCancion(Cancion cancion, int IDAlbum) {
        Connection con = null;
        PreparedStatement stmCancion = null;
        Statement stmtUltimoIDCancion = null;
        ResultSet rsUltimoIDCancion = null;

        try {
            con = this.getConexion();

            // Consulta para insertar la canción
            String sqlCancion = "INSERT INTO CANCION (nombre, IDCancion, duracion, idioma, nombreGenero, letra, visualizaciones, IDAlbum, explicito) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Consulta para obtener el último ID de canción
            String sqlUltimoIDCancion = "SELECT MAX(IDCancion) FROM CANCION";

            // Obtener el último ID de canción
            stmtUltimoIDCancion = con.createStatement();
            rsUltimoIDCancion = stmtUltimoIDCancion.executeQuery(sqlUltimoIDCancion);
            int ultimoIDCancion = 0;
            if (rsUltimoIDCancion.next()) {
                ultimoIDCancion = rsUltimoIDCancion.getInt(1);
                // Incrementar el último ID de canción para obtener un nuevo ID único
                int nuevoIDCancion = ultimoIDCancion + 1;

                // Insertar la canción
                stmCancion = con.prepareStatement(sqlCancion);
                stmCancion.setString(1, cancion.getNombre());
                stmCancion.setInt(2, nuevoIDCancion);
                stmCancion.setString(3, cancion.getDuracion());
                stmCancion.setString(4, cancion.getIdioma());
                stmCancion.setString(5, cancion.getNombreGenero());
                stmCancion.setBoolean(6, cancion.isLetra());
                stmCancion.setInt(7, cancion.getVisualizaciones());
                stmCancion.setInt(8, IDAlbum); // Utilizar el ID de álbum proporcionado
                stmCancion.setBoolean(9, cancion.isExplicito());

                stmCancion.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rsUltimoIDCancion != null) {
                    rsUltimoIDCancion.close();
                }
                if (stmtUltimoIDCancion != null) {
                    stmtUltimoIDCancion.close();
                }
                if (stmCancion != null) {
                    stmCancion.close();
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

