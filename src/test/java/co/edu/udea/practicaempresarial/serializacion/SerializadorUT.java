package co.edu.udea.practicaempresarial.serializacion;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import co.edu.udea.practicaempresarial.modelo.Afiliado;
import co.edu.udea.practicaempresarial.modelo.SeccionA;

public class SerializadorUT {

    private String jsonGenerico;
    private String jsonSeccionA;
    private String jsonSeccionAOrdenado;
    private String jsonListaAfiliados;

    @Before()
    public void inicializarInformacion() {
        this.jsonGenerico = this.obtenerInformacion("src/test/resources/json/serializacionconfecha.json");
        this.jsonSeccionA = this.obtenerInformacion("src/test/resources/json/seccionA.json");
        this.jsonSeccionAOrdenado = this.obtenerInformacion("src/test/resources/json/seccionAOrdenado.json");
        this.jsonListaAfiliados = this.obtenerInformacion("src/test/resources/json/listaAfiliados.json");
    }

    @Test()
    public void convertirJsonAObjetoConFecha() throws Exception {
        ClaseSerializada objeto = (ClaseSerializada) Serializador.jsonAObjeto(jsonGenerico, ClaseSerializada.class,
                "yyyyMMdd");

        assertNotNull(objeto);
        assertThat(objeto.cadena, is("cadena1"));
        assertThat(objeto.fecha, is(new SimpleDateFormat("yyyyMMdd").parse("20150210")));
        assertThat(objeto.numero, is(10500000L));
    }

    @Test()
    public void convertirJsonAObjetoEntidadNegocio() {
        SeccionA seccionA = (SeccionA) Serializador.jsonAObjeto(this.jsonSeccionA, SeccionA.class);

        assertNotNull(seccionA);
        assertEquals(seccionA.getAnioCotizacion(), "2015");
        assertTrue(seccionA.getNitARL().isEmpty());
        assertEquals(seccionA.getNumeroRegistro(), "00000");
        assertEquals(seccionA.getNombreAportante(), "ANDERSSONGARCIASOTELO");
        assertEquals(seccionA.getMesCotizacion(), "09");
        assertEquals(seccionA.getTipoDocumentoAportante(), "CC");
        assertEquals(seccionA.getNumeroDocumentoAportante(), "123456789");
        assertEquals(seccionA.getTipoAportante(), "2");
        assertEquals(seccionA.getEmail(), "ANDERSSONGARCIASOTELO@GMAIL.COM");
        assertEquals(seccionA.getDiaFechaPago(), "01");
        assertEquals(seccionA.getAnioFechaPago(), "2015");
        assertEquals(seccionA.getNumeroPlanilla(), "454521");
        assertEquals(seccionA.getMesFechaPago(), "09");
    }

    @Test()
    public void convertirObjetoAJsonConFecha() {
        ClaseSerializada cs = new ClaseSerializada();
        cs.cadena = "cadena de prueba";
        cs.fecha = new Date();
        cs.numero = 646546L;

        String json = Serializador.objetoAJson(cs, "ddMMyyyy");
        String cadenaJson = "{\"cadena\":\"cadena de prueba\",\"fecha\":\""
                + new SimpleDateFormat("ddMMyyyy").format(new Date()) + "\",\"numero\":646546}";

        assertEquals(json, cadenaJson);
    }

    @Test()
    public void convertirObjetoAJsonNegocio() {
        SeccionA seccionA = new SeccionA();
        seccionA.setAnioCotizacion("2015");
        seccionA.setNumeroRegistro("00000");
        seccionA.setNombreAportante("ANDERSSONGARCIASOTELO");
        seccionA.setMesCotizacion("09");
        seccionA.setTipoDocumentoAportante("CC");
        seccionA.setNumeroDocumentoAportante("123456789");
        seccionA.setTipoAportante("2");
        seccionA.setEmail("ANDERSSONGARCIASOTELO@GMAIL.COM");
        seccionA.setDiaFechaPago("01");
        seccionA.setAnioFechaPago("2015");
        seccionA.setNumeroPlanilla("454521");
        seccionA.setMesFechaPago("09");

        String json = Serializador.objetoAJson(seccionA);

        assertEquals(this.jsonSeccionAOrdenado, json);
    }

    @Test()
    public void convertirJsonAObjetoLista() {
        List<Object> afiliados = Serializador.jsonAObjeto(this.jsonListaAfiliados, new TypeToken<List<Afiliado>>() {
        }.getType());

        assertTrue(afiliados.size() == 3);
        assertTrue(afiliados.get(0) instanceof Afiliado);
        assertTrue(afiliados.get(1) instanceof Afiliado);
        assertTrue(afiliados.get(2) instanceof Afiliado);
        assertEquals(((Afiliado) afiliados.get(0)).getCodigoEps(), null);
        assertEquals(((Afiliado) afiliados.get(0)).getTipoIdentificacion(), "CC");
        assertEquals(((Afiliado) afiliados.get(0)).getSalarioBasico(), "1500000");
        assertEquals(((Afiliado) afiliados.get(1)).getDiasCotizados(), "30");
        assertEquals(((Afiliado) afiliados.get(1)).getPrimerNombre(), "Ana");
        assertEquals(((Afiliado) afiliados.get(1)).getSegundoApellido(), "Garzon");
        assertEquals(((Afiliado) afiliados.get(2)).getSegundoNombre(), null);
        assertEquals(((Afiliado) afiliados.get(2)).getNumeroIdentificacion(), "369852147");
        assertEquals(((Afiliado) afiliados.get(2)).getSegundoApellido(), null);
    }

    private String obtenerInformacion(String ruta) {
        StringBuilder json = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.lines().map(s -> s.trim()).forEach(s -> json.append(s));
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    private class ClaseSerializada {
        String cadena;
        Date fecha;
        Long numero;
    }
}
