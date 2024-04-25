package baseDatos;

import aplicacion.Album;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    public int publicarAlbum(Album album, int IDDiscografica, String IDArtista) {
        Connection con = null;
        PreparedStatement stmAlbum = null;
        PreparedStatement stmComponer = null;
        ResultSet rsIDAlbum = null;
        int nuevoIDAlbum = -1;
        Statement stmUltimoIDAlbum = null;

        con = this.getConexion();
        try {
            String sqlUltimoIDAlbum = "SELECT MAX(IDAlbum) FROM ALBUM";

            stmUltimoIDAlbum = con.prepareStatement(sqlUltimoIDAlbum);

            rsIDAlbum = stmUltimoIDAlbum.executeQuery(sqlUltimoIDAlbum);            // Consulta para obtener el último ID de álbum
            if (rsIDAlbum.next()) {
                nuevoIDAlbum = rsIDAlbum.getInt(1) + 1;
            }

            // Consulta para insertar el álbum
            String sqlInsertAlbum = "INSERT INTO ALBUM (nombre, IDAlbum, tipo, añoLanzamiento, IDDiscografica) " +
                    "VALUES (?, ?, ?, ?, ?)";

            // Insertar el álbum
            stmAlbum = con.prepareStatement(sqlInsertAlbum);
            stmAlbum.setString(1, album.getNombre());
            stmAlbum.setInt(2, nuevoIDAlbum);
            stmAlbum.setString(3, album.getTipo());
            stmAlbum.setInt(4, album.getAñoLanzamiento());
            stmAlbum.setInt(5, IDDiscografica);
            stmAlbum.executeUpdate();

            // Consulta para insertar en la tabla COMPONER
            String sqlInsertComponer = "INSERT INTO COMPONER (IDAlbum, IDArtista) VALUES (?, ?)";

            // Insertar en la tabla COMPONER
            stmComponer = con.prepareStatement(sqlInsertComponer);
            stmComponer.setInt(1, nuevoIDAlbum);
            stmComponer.setString(2, IDArtista);
            stmComponer.executeUpdate();



        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            return -1; // Si ocurre una excepción, devuelve un ID inválido
        } finally {
            try {
                if (rsIDAlbum != null) {
                    rsIDAlbum.close();
                }
                if (stmUltimoIDAlbum != null) {
                    stmUltimoIDAlbum.close();
                }
                if (stmAlbum != null) {
                    stmAlbum.close();
                }
                if (stmComponer != null) {
                    stmComponer.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }

        }
        return nuevoIDAlbum;

    }

    public void registrarAlbum(Album album, int IDDiscografica, String IDArtista) {
        Connection con;
        PreparedStatement stmAlbum=null,stmComponer=null;

        con=this.getConexion();

        try {
            stmAlbum=con.prepareStatement("INSERT INTO ALBUM (nombre, IDAlbum, tipo, añoLanzamiento, IDDiscografica) " +
                    "VALUES (?, (SELECT MAX(IDAlbum) + 1 FROM ALBUM), ?, ?, ?);");


            stmAlbum.setString(1, album.getNombre());
            stmAlbum.setString(2, album.getTipo());
            stmAlbum.setInt(3, album.getAñoLanzamiento());
            stmAlbum.setInt(4, IDDiscografica);
            stmAlbum.executeUpdate();


            // Consulta para insertar en la tabla COMPONER
            String sqlInsertComponer = "INSERT INTO COMPONER (IDAlbum, IDArtista) VALUES (SELECT MAX(IDAlbum), ?)";

            // Insertar en la tabla COMPONER
            stmComponer = con.prepareStatement(sqlInsertComponer);
            stmComponer.setString(1, IDArtista);
            stmComponer.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally{
            try {stmAlbum.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }


}