package aplicacion;

public class Elemento {
    String nombre;
    String tipo;
    String artista;

    public Elemento(String nombre, String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
    }
    public Elemento(String nombre, String artista,int e){
        this.nombre=nombre;
        this.artista=artista;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }
}
