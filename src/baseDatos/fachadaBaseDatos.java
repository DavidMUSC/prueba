package baseDatos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import aplicacion.*;

public class fachadaBaseDatos {
    private aplicacion.fachadaAplicacion fa;
    private java.sql.Connection conexion;

    private DAOOyentes daoOyentes;

    public fachadaBaseDatos (aplicacion.fachadaAplicacion fa){

        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();


            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                            configuracion.getProperty("servidor")+":"+
                            configuracion.getProperty("puerto")+"/"+
                            configuracion.getProperty("baseDatos"),
                    usuario);

            //TODO: iniciar daos aqui
            daoOyentes = new DAOOyentes(conexion,fa);

        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        }
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }



    }

    public Oyente validarUsuario(String nombre, String contrasena){
        return daoOyentes.validarUsuario(nombre, contrasena);
    }
    public void registrarOyente(String usuario, String correo, String contrasena, String fechaNacimiento) {
        daoOyentes.registrarOyente(usuario, correo, contrasena, fechaNacimiento);
    }

}
