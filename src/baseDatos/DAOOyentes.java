package baseDatos;
import aplicacion.*;
import java.sql.*;
public class DAOOyentes extends abstractDAO{
    public DAOOyentes (Connection conexion, aplicacion.fachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Oyente validarUsuario(String nombre, String contraseña){
        Oyente resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsOyente;

        con=this.getConexion();

        try {
            stmUsuario=con.prepareStatement("select nombre,contraseña,email,fechaNacimiento,tipoPlan,fechaPago,fechaVencimiento "+
                    "from oyente "+
                    "where nombre = ? and contraseña = ?");
            stmUsuario.setString(1, nombre);
            stmUsuario.setString(2, contraseña);
            rsOyente=stmUsuario.executeQuery();
            if (rsOyente.next())
            {
                resultado = new Oyente(rsOyente.getString("nombre"),rsOyente.getString("contraseña"),rsOyente.getString("email"),
                        rsOyente.getDate("fechaNacimiento"),rsOyente.getString("tipoPlan"),rsOyente.getDate("fechaPago"),
                        rsOyente.getDate("fechaVencimiento"));

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
