package aplicacion;

public class Podcast {
    private int idPodcast;
    private String nombre;
    private String creador;

    // Constructor
    public Podcast(int idPodcast, String nombre, String creador) {
        this.idPodcast = idPodcast;
        this.nombre = nombre;
        this.creador = creador;
    }

    // Getters y setters
    public int getIdPodcast() {
        return idPodcast;
    }

    public void setIdPodcast(int idPodcast) {
        this.idPodcast = idPodcast;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return "Podcast{" +
                "idPodcast=" + idPodcast +
                ", nombre='" + nombre + '\'' +
                ", creador='" + creador + '\'' +
                '}';
    }
}
