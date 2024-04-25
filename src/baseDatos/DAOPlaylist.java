package baseDatos;

import aplicacion.Playlist;
import aplicacion.Elemento;
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
                    "    (SELECT MAX(IDPlaylist) + 1 FROM PLAYLIST),\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?\n" +
                    ");");
            stmPlaylist.setString(1, nombre);
            LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fechaFormateada = fechaActual.format(formato);
            Date fechaSql = Date.valueOf(fechaFormateada);
            stmPlaylist.setDate(2, fechaSql);
            stmPlaylist.setString(3, usuario);

            stmPlaylist.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally{
            try {stmPlaylist.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    public void insertarCancionEnPlaylist(String nombreCancion,int IDPlaylist) {
        Connection con;
        PreparedStatement stmPlaylist=null;

        con=this.getConexion();

        try {
            stmPlaylist=con.prepareStatement("INSERT INTO FORMARPARTE (IDCancion,IDPlaylist)\n" +
                    "VALUES ((select IDCancion from Cancion where nombre = ?),?);");
            stmPlaylist.setString(1, nombreCancion);
            stmPlaylist.setInt(2, IDPlaylist);

            stmPlaylist.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally{
            try {stmPlaylist.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    public int buscarIDPlaylists(String terminoBusqueda,String usuario) {
        Connection con;
        PreparedStatement stmPlaylist = null;
        ResultSet rsPlaylist;
        List<Playlist> playlistsEncontradas = new ArrayList<>();
        int idPlaylist=0;
        con = this.getConexion();

        String sql = "SELECT IDPlaylist FROM PLAYLIST WHERE nombrePlaylist = ? and IDOyente = ?";
        try {
            stmPlaylist = con.prepareStatement(sql);
            stmPlaylist.setString(1, terminoBusqueda);
            stmPlaylist.setString(2, usuario);
            rsPlaylist = stmPlaylist.executeQuery();
            while (rsPlaylist.next()) {
                idPlaylist = rsPlaylist.getInt("IDPlaylist");
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
        return idPlaylist;
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

    public List<Elemento> buscarPlaylistsUsuario(String nombreUsuario) {
        Connection con;
        PreparedStatement stmPlaylist = null;
        ResultSet rsPlaylist;
        List<Elemento> playlistsEncontradas = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT nombrePlaylist, FROM PLAYLIST WHERE IDOyente = ?";
        try {
            stmPlaylist = con.prepareStatement(sql);
            stmPlaylist.setString(1, nombreUsuario);

            rsPlaylist = stmPlaylist.executeQuery();
            while (rsPlaylist.next()) {
                int idPlaylist = rsPlaylist.getInt("IDPlaylist");
                String nombrePlaylist = rsPlaylist.getString("nombrePlaylist");
                String creador = rsPlaylist.getString("IDOyente");
                String fechaCreacion = rsPlaylist.getString("fechaCreacion");

                Playlist playlist = new Playlist(idPlaylist, nombrePlaylist, creador, fechaCreacion);

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