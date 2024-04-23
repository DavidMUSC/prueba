package baseDatos;

import aplicacion.Artista;
import aplicacion.Oyente;
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

    public List<Artista> buscarArtistas(String terminoBusqueda) throws SQLException {
        Artista resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsOyente;
        List<Artista> artistasEncontrados = new ArrayList<>();

        con = this.getConexion();

        String sql = "SELECT * FROM ARTISTA WHERE nombre LIKE ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, "%" + terminoBusqueda + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String contraseña = resultSet.getString("contraseña");
                String email = resultSet.getString("email");
                // Otros campos del artista

                //Artista artista = new Artista(nombre, contraseña, email);
                // Agregar más campos al constructor de Artista si es necesario

                //artistasEncontrados.add(artista);
            }
        }

        return artistasEncontrados;
    }
}
