package baseDatos;

import aplicacion.Playlist;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DAOPlaylist extends abstractDAO {
    public DAOPlaylist(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void registrarPlaylist(String nombre, String usuario) {
        Connection con;
        PreparedStatement stmPlaylist=null;

        con=this.getConexion();

        try {
            stmPlaylist=con.prepareStatement("INSERT INTO PLAYLIST (IDPlaylist, nombrePlaylist, fechaCreacion, IDOyente)\n" +
                    "VALUES (\n" +
                    "    (SELECT COALESCE(MAX(IDPlaylist), 0) + 1 FROM PLAYLIST WHERE IDOyente = ?),\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?\n" +
                    ");");
            stmPlaylist.setString(1, usuario);
            stmPlaylist.setString(2, nombre);
            LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fechaFormateada = fechaActual.format(formato);
            Date fechaSql = Date.valueOf(fechaFormateada);
            stmPlaylist.setDate(3, fechaSql);
            stmPlaylist.setString(4, usuario);

            stmPlaylist.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally{
            try {stmPlaylist.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    public List<Playlist> buscarPlaylists(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmPlaylist = null;
        ResultSet rsPlaylist;
        List<Playlist> playlistsEncontradas = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM PLAYLIST WHERE nombrePlaylist LIKE ?";
        try {
            stmPlaylist = con.prepareStatement(sql);
            stmPlaylist.setString(1, "%" + terminoBusqueda + "%");

            rsPlaylist = stmPlaylist.executeQuery();
            while (rsPlaylist.next()) {
                int idPlaylist = rsPlaylist.getInt("IDPlaylist");
                String nombrePlaylist = rsPlaylist.getString("nombrePlaylist");
                String creador = rsPlaylist.getString("IDOyente");
                String fechaCreacion = rsPlaylist.getString("fechaCreacion");

                Playlist playlist = new Playlist(idPlaylist, nombrePlaylist, creador, fechaCreacion);
                // Agregar más campos al constructor de Playlist si es necesario

                playlistsEncontradas.add(playlist);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPlaylist.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return playlistsEncontradas;
    }
    
}