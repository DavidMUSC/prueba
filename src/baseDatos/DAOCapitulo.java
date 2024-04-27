package baseDatos;

import aplicacion.Capitulo;
import aplicacion.Podcast;
import aplicacion.Artista;
import java.sql.*;
import java.util.*;

public class DAOCapitulo extends abstractDAO {

    public DAOCapitulo(Connection conexion, aplicacion.fachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void insertarCapitulo(Capitulo capitulo) {
        Connection con = null;
        PreparedStatement stmCapitulo = null;

        try {
            con = getConexion();

            // Consulta para obtener el último ID de capítulo para el podcast dado
            String sqlUltimoIDCapitulo = "SELECT MAX(IDCapitulo) FROM Capitulo WHERE IDPodcast = ?";
            PreparedStatement stmUltimoIDCapitulo = con.prepareStatement(sqlUltimoIDCapitulo);
            stmUltimoIDCapitulo.setInt(1, capitulo.getIDPodcast());
            ResultSet rsUltimoIDCapitulo = stmUltimoIDCapitulo.executeQuery();

            int ultimoIDCapitulo = 0;
            if (rsUltimoIDCapitulo.next()) {
                ultimoIDCapitulo = rsUltimoIDCapitulo.getInt(1);
            }

            // Incrementar el último ID de capítulo para obtener un nuevo ID único
            int nuevoIDCapitulo = ultimoIDCapitulo + 1;

            // Consulta para insertar el capítulo
            String sqlInsertCapitulo = "INSERT INTO Capitulo (nombre, IDCapitulo, duracion, explicito, IDPodcast) " +
                    "VALUES (?, ?, ?, ?, ?)";

            // Insertar el capítulo
            stmCapitulo = con.prepareStatement(sqlInsertCapitulo);
            stmCapitulo.setString(1, capitulo.getNombre());
            stmCapitulo.setInt(2, nuevoIDCapitulo);
            stmCapitulo.setInt(3, capitulo.getDuracion());
            stmCapitulo.setBoolean(4, capitulo.isExplicito());
            stmCapitulo.setInt(5, capitulo.getIDPodcast());
            stmCapitulo.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmCapitulo != null) {
                    stmCapitulo.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void eliminarCapitulo(int IDCapitulo) {
        Connection con = null;
        PreparedStatement stmEliminarCapitulo = null;

        try {
            con = getConexion();

            // Consulta para eliminar el capítulo
            String sqlEliminarCapitulo = "DELETE FROM Capitulo WHERE IDCapitulo = ?";

            // Eliminar el capítulo
            stmEliminarCapitulo = con.prepareStatement(sqlEliminarCapitulo);
            stmEliminarCapitulo.setInt(1, IDCapitulo);
            stmEliminarCapitulo.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEliminarCapitulo != null) {
                    stmEliminarCapitulo.close();
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
