package aplicacion;

import java.sql.Date;

public class Artista {
    private String nombre;
    private String contrasena;
    private String email;
    private Date fechaNacimiento;
    private String nombreArtistico;
    private String paisNacimiento;
    public Artista(String nombre, String contrasena, String email, Date fechaNacimiento, String nombreArtistico, String paisNacimiento) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreArtistico = nombreArtistico;
        this.paisNacimiento = paisNacimiento;
    }
}
