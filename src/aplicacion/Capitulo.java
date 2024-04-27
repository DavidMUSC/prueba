package aplicacion;

public class Capitulo {
    private String nombre;
    private int IDCapitulo;
    private int duracion;
    private boolean explicito;
    private int IDPodcast;

    public Capitulo(String nombre, int IDCapitulo, int duracion, boolean explicito, int IDPodcast) {
        this.nombre = nombre;
        this.IDCapitulo = IDCapitulo;
        this.duracion = duracion;
        this.explicito = explicito;
        this.IDPodcast = IDPodcast;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIDCapitulo() {
        return IDCapitulo;
    }

    public void setIDCapitulo(int IDCapitulo) {
        this.IDCapitulo = IDCapitulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isExplicito() {
        return explicito;
    }

    public void setExplicito(boolean explicito) {
        this.explicito = explicito;
    }

    public int getIDPodcast() {
        return IDPodcast;
    }

    public void setIDPodcast(int IDPodcast) {
        this.IDPodcast = IDPodcast;
    }
}

