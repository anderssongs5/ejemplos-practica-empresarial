package co.edu.udea.practicaempresarial;

public class DatosIniciales {

    private String puerto;
    private String host;
    private String nombreServicio;
    private String usuarioBD;
    private String passwordBD;
    private String rutaPilasAsobancaria;
    private String rutaArchivoBanco;
    private String dniIngresa;
    private String mapeoUnidadK;

    private static DatosIniciales instance;

    private DatosIniciales() {
        super();
    }

    public static synchronized DatosIniciales getInstance() {
        if (instance == null) {
            instance = new DatosIniciales();
        }

        return instance;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getUsuarioBD() {
        return usuarioBD;
    }

    public void setUsuarioBD(String usuarioBD) {
        this.usuarioBD = usuarioBD;
    }

    public String getPasswordBD() {
        return passwordBD;
    }

    public void setPasswordBD(String passwordBD) {
        this.passwordBD = passwordBD;
    }

    public String getRutaPilasAsobancaria() {
        return rutaPilasAsobancaria;
    }

    public void setRutaPilasAsobancaria(String rutaPilasAsobancaria) {
        this.rutaPilasAsobancaria = rutaPilasAsobancaria;
    }

    public String getRutaArchivoBanco() {
        return rutaArchivoBanco;
    }

    public void setRutaArchivoBanco(String rutaArchivoBanco) {
        this.rutaArchivoBanco = rutaArchivoBanco;
    }

    public String getDniIngresa() {
        return dniIngresa;
    }

    public void setDniIngresa(String dniIngresa) {
        this.dniIngresa = dniIngresa;
    }

    public String getMapeoUnidadK() {
        return mapeoUnidadK;
    }

    public void setMapeoUnidadK(String mapeoUnidadK) {
        this.mapeoUnidadK = mapeoUnidadK;
    }
}