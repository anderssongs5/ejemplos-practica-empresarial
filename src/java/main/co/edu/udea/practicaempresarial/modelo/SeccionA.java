package co.edu.udea.practicaempresarial.modelo;

import com.google.gson.annotations.SerializedName;

public class SeccionA {

    private String numeroRegistro;
    private String nitARL;
    private String nombreAportante;
    private String tipoDocumentoAportante;
    private String numeroDocumentoAportante;
    private String tipoAportante;
    private String email;
    private String anioCotizacion;
    private String mesCotizacion;
    private String diaFechaPago;
    private String mesFechaPago;
    private String anioFechaPago;
    @SerializedName("nroPlanilla")
    private String numeroPlanilla;

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getNitARL() {
        return nitARL;
    }

    public void setNitARL(String nitARL) {
        this.nitARL = nitARL;
    }

    public String getNombreAportante() {
        return nombreAportante;
    }

    public void setNombreAportante(String nombreAportante) {
        this.nombreAportante = nombreAportante;
    }

    public String getTipoDocumentoAportante() {
        return tipoDocumentoAportante;
    }

    public void setTipoDocumentoAportante(String tipoDocumentoAportante) {
        this.tipoDocumentoAportante = tipoDocumentoAportante;
    }

    public String getNumeroDocumentoAportante() {
        return numeroDocumentoAportante;
    }

    public void setNumeroDocumentoAportante(String numeroDocumentoAportante) {
        this.numeroDocumentoAportante = numeroDocumentoAportante;
    }

    public String getTipoAportante() {
        return tipoAportante;
    }

    public void setTipoAportante(String tipoAportante) {
        this.tipoAportante = tipoAportante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnioCotizacion() {
        return anioCotizacion;
    }

    public void setAnioCotizacion(String anioCotizacion) {
        this.anioCotizacion = anioCotizacion;
    }

    public String getMesCotizacion() {
        return mesCotizacion;
    }

    public void setMesCotizacion(String mesCotizacion) {
        this.mesCotizacion = mesCotizacion;
    }

    public String getDiaFechaPago() {
        return diaFechaPago;
    }

    public void setDiaFechaPago(String diaFechaPago) {
        this.diaFechaPago = diaFechaPago;
    }

    public String getMesFechaPago() {
        return mesFechaPago;
    }

    public void setMesFechaPago(String mesFechaPago) {
        this.mesFechaPago = mesFechaPago;
    }

    public String getAnioFechaPago() {
        return anioFechaPago;
    }

    public void setAnioFechaPago(String anioFechaPago) {
        this.anioFechaPago = anioFechaPago;
    }

    public String getNumeroPlanilla() {
        return numeroPlanilla;
    }

    public void setNumeroPlanilla(String numeroPlanilla) {
        this.numeroPlanilla = numeroPlanilla;
    }
}
