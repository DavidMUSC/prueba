package baseDatos;
import aplicacion.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
}
