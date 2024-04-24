package baseDatos;

import aplicacion.Artista;
import aplicacion.Oyente;

import java.sql.Date;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOArtistas extends abstractDAO {
    public DAOArtistas (Connection conexion, aplicacion.fachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Artista validarArtista(String nombre, String contrasena){
        Artista resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsOyente;

        con=this.getConexion();

        try {
            stmUsuario=con.prepareStatement("select nombre,contraseña,email,fechaNacimiento,nombreArtistico,paisNacimiento "+
                    "from artista "+
                    "where nombre = ? and contraseña = ?");
            stmUsuario.setString(1, nombre);
            stmUsuario.setString(2, contrasena);
            rsOyente=stmUsuario.executeQuery();
            if (rsOyente.next())
            {
                resultado = new Artista(rsOyente.getString("nombre"),rsOyente.getString("contraseña"),rsOyente.getString("email"),
                        rsOyente.getDate("fechaNacimiento"),rsOyente.getString("nombreArtistico"),rsOyente.getString("paisNacimiento"));

            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    public List<Artista> buscarArtistas(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmArtista=null;
        ResultSet rsArtista;
        List<Artista> artistasEncontrados = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM ARTISTA WHERE nombre LIKE ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, "%" + terminoBusqueda + "%");

            rsArtista = stmArtista.executeQuery();
            while (rsArtista.next()) {
                String nombre = rsArtista.getString("nombre");
                String contraseña = rsArtista.getString("contraseña");
                String email = rsArtista.getString("email");
                Date fechaNacimiento  = rsArtista.getDate("fechaNacimiento");
                String nombreArtistico = rsArtista.getString("nombreArtistico");
                String paisNacimiento = rsArtista.getString("paisNacimiento");


                Artista artista = new Artista(nombre, contraseña, email, fechaNacimiento, nombreArtistico, paisNacimiento);

                artistasEncontrados.add(artista);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmArtista.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return artistasEncontrados;
    }
}
