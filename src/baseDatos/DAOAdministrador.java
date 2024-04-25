package baseDatos;
import aplicacion.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOAdministrador extends abstractDAO {
    public DAOAdministrador (Connection conexion, aplicacion.fachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Administrador validarAdministrador(String nombre, String contrasena){
        Administrador resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsAdmin;

        con=this.getConexion();

        try {
            stmUsuario=con.prepareStatement("select nombre,contraseña,email,fechaNacimiento "+
                    "from administrador "+
                    "where nombre = ? and contraseña = ?");
            stmUsuario.setString(1, nombre);
            stmUsuario.setString(2, contrasena);
            rsAdmin=stmUsuario.executeQuery();
            if (rsAdmin.next())
            {
                resultado = new Administrador(rsAdmin.getString("nombre"),rsAdmin.getString("contraseña"),rsAdmin.getString("email"),
                        rsAdmin.getDate("fechaNacimiento"));

            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    public List<Artista> buscarAdminAutentificacion(String terminoBusqueda) {
        Connection con;
        PreparedStatement stmArtista=null;
        ResultSet rsArtista;
        List<Artista> artistasEncontrados = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM ARTISTA WHERE nombre = ?";
        try {
            stmArtista = con.prepareStatement(sql);
            stmArtista.setString(1, terminoBusqueda);

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
