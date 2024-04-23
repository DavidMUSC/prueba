package baseDatos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
import aplicacion.*;

public class fachadaBaseDatos {
    private aplicacion.fachadaAplicacion fa;
    private java.sql.Connection conexion;

    private DAOOyentes daoOyentes;
    private DAOArtistas daoArtista;

    public fachadaBaseDatos (aplicacion.fachadaAplicacion fa){

        int i = 12;
        i=13;
        System.out.println(i);
        try {
            // Intenta cargar dinámicamente la clase del driver JDBC
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver JDBC cargado exitosamente.");
        } catch (ClassNotFoundException e) {
            // Captura la excepción si la clase no puede ser encontrada
            System.err.println("Error: No se pudo encontrar la clase del driver JDBC.");
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://flora.db.elephantsql.com:5432/pqnougax";
        String usuario = "pqnougax";
        String contrasena = "EDlmJk7k_3RxO6UeEZUZ6c6oKqC5Na0o";

        try {
            conexion = DriverManager.getConnection(url,usuario,contrasena);
            //TODO: iniciar daos aqui
            daoOyentes = new DAOOyentes(conexion,fa);
            daoArtista = new DAOArtistas(conexion, fa);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }

    }

    //MÉTODOS OYENTES
    public Oyente validarUsuario(String nombre, String contrasena){
        return daoOyentes.validarUsuario(nombre, contrasena);
    }
    public void registrarOyente(String usuario, String correo, String contrasena, String fechaNacimiento) {
        daoOyentes.registrarOyente(usuario, correo, contrasena, fechaNacimiento);
    }

    //MÉTODOS ARTISTAS
    public Artista validarArtista(String nombre, String contrasena){
        daoArtista
    }

}
