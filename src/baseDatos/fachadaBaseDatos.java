package baseDatos;import java.io.FileInputStream;import java.io.FileNotFoundException;import java.io.IOException;import java.util.List;import java.util.Properties;import java.sql.*;import aplicacion.*;public class fachadaBaseDatos {    private aplicacion.fachadaAplicacion fa;    private java.sql.Connection conexion;    private DAOOyentes daoOyentes;    private DAOArtistas daoArtista;    private DAOAdministrador daoAdministrador;    private DAOPlaylist daoPlaylist;    private DAOCancion daoCancion;    private DAOAlbum daoAlbum;    private DAOPodcast daoPodcast;    private DAODiscografica daoDiscografica;    public fachadaBaseDatos (aplicacion.fachadaAplicacion fa){        int i = 12;        i=13;        System.out.println(i);        try {            // Intenta cargar dinámicamente la clase del driver JDBC            Class.forName("org.postgresql.Driver");            System.out.println("Driver JDBC cargado exitosamente.");        } catch (ClassNotFoundException e) {            // Captura la excepción si la clase no puede ser encontrada            System.err.println("Error: No se pudo encontrar la clase del driver JDBC.");            e.printStackTrace();        }        String url = "jdbc:postgresql://flora.db.elephantsql.com:5432/pqnougax";        String usuario = "pqnougax";        String contrasena = "EDlmJk7k_3RxO6UeEZUZ6c6oKqC5Na0o";        try {            conexion = DriverManager.getConnection(url,usuario,contrasena);            //TODO: iniciar daos aqui            daoOyentes = new DAOOyentes(conexion,fa);            daoArtista = new DAOArtistas(conexion, fa);            daoAdministrador = new DAOAdministrador(conexion, fa);            daoAlbum = new DAOAlbum(conexion, fa);            daoCancion = new DAOCancion(conexion, fa);            daoPlaylist = new DAOPlaylist(conexion,fa);            daoPodcast = new DAOPodcast(conexion, fa);            daoDiscografica = new DAODiscografica(conexion, fa);            System.out.println("Conexión exitosa a la base de datos.");        } catch (SQLException e) {            System.err.println("Error al conectar con la base de datos: " + e.getMessage());        }    }    //MÉTODOS OYENTES    public Oyente validarUsuario(String nombre, String contrasena){        return daoOyentes.validarUsuario(nombre, contrasena);    }    public void registrarOyente(String usuario, String correo, String contrasena, String fechaNacimiento) {        daoOyentes.registrarOyente(usuario, correo, contrasena, fechaNacimiento);    }    //MÉTODOS ARTISTAS    public Artista validarArtista(String nombre, String contrasena){        Artista a;        a = daoArtista.validarArtista(nombre, contrasena);        return a;    }    public List<Artista> obtenerArtistasDePodcast(String nombrePodcast) {        return daoArtista.obtenerArtistasDePodcast(nombrePodcast);    }    public List<Artista> buscarArtistas(String terminoBusqueda){        return daoArtista.buscarArtistas(terminoBusqueda);    }    public List<Artista> buscarArtistasAutentificacion(String terminoBusqueda) {        return daoArtista.buscarArtistasAutentificacion(terminoBusqueda);    }    public int obtenerIDArtistaPorNombre(String nombreArtista){        return daoArtista.obtenerIDArtistaPorNombre(nombreArtista);    }    //MÉTODOS ADMIN    public Administrador validarAdministrador(String nombre, String contrasena) {        Administrador a;        a = daoAdministrador.validarAdministrador(nombre, contrasena);        return a;    }    public List<Administrador> buscarAdminAutentificacion(String terminoBusqueda) {        return daoAdministrador.buscarAdminAutentificacion(terminoBusqueda);    }    //MÉTODOS CANCIÓN    public List<Artista> obtenerArtistasDeCancion(String nombreCancion) {        return daoCancion.obtenerArtistasDeCancion(nombreCancion);    }    public List<Cancion> buscarCanciones(String terminoBusqueda){        return daoCancion.buscarCanciones(terminoBusqueda);    }    public List<Cancion> buscarCancionesEn(String terminoBusqueda) {        return daoCancion.buscarCancionesEn(terminoBusqueda);    }    public String obtenerArtistaDeCancion(String nombreCancion){        return daoCancion.obtenerArtistaDeCancion(nombreCancion);    }    public void publicarCancion(Cancion cancion, int IDAlbum){        daoCancion.publicarCancion(cancion, IDAlbum);    }    //MÉTODOS ALBUM    public List<Album> buscarAlbumes(String terminoBusqueda){        return daoAlbum.buscarAlbumes(terminoBusqueda);    }    public String obtenerArtistaDeAlbum(String nombreAlbum){        return daoAlbum.obtenerArtistaDeAlbum(nombreAlbum);    }    public int publicarAlbum(Album album, int IDDiscografica, String IDArtista){        daoAlbum.registrarAlbum(album, IDDiscografica, IDArtista);        return 1;    }    public int obtenerIDnuevo() {        return daoAlbum.obtenerIDnuevo();    }    //MÉTODOS PODCAST    public List<Podcast> buscarPodcasts(String terminoBusqueda){        return daoPodcast.buscarPodcasts(terminoBusqueda);    }    public String obtenerArtistaDePodcast(String nombrePodcast){        return daoPodcast.obtenerArtistaDePodcast(nombrePodcast);    }    public void publicarPodcast(Podcast podcast, int idArtista){        daoPodcast.publicarPodcast(podcast, idArtista);    }    //MÉTODOS PLAYLIST    public List<Playlist> buscarPlaylists(String terminoBusqueda){        return daoPlaylist.buscarPlaylists(terminoBusqueda);    }    public void registrarPlaylist(String nombre, String usuario) {        daoPlaylist.registrarPlaylist(nombre,usuario);    }    public List<Elemento> buscarPlaylistsUsuario(String nombreUsuario){        return daoPlaylist.buscarPlaylistsUsuario(nombreUsuario);    }    public int buscarIDPlaylists(String terminoBusqueda,String usuario) {        return daoPlaylist.buscarIDPlaylists(terminoBusqueda,usuario);    }    public void insertarCancionEnPlaylist(String nombreCancion,int IDPlaylist){        daoPlaylist.insertarCancionEnPlaylist(nombreCancion,IDPlaylist);    }    //METODOS DISCOGRAFICA    public int insertarDiscografica(String nombreDiscografica){        return daoDiscografica.insertarDiscografica(nombreDiscografica);    }    public Discografica buscarDiscografica(String nombreDiscografica){        return daoDiscografica.buscarDiscografica(nombreDiscografica);    }}