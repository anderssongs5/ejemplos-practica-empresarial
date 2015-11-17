package co.edu.udea.practicaempresarial.serializacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.stream.JsonReader;

import co.edu.udea.practicaempresarial.modelo.Afiliado;
import co.edu.udea.practicaempresarial.modelo.SeccionB;

public class SeccionBAdaptadorUT {

    private SeccionBAdaptador seccionBAdaptador;
    private String jsonAfiliado;
    private String jsonAfiliados;

    @Before()
    public void inicializarInformacion() {
        this.seccionBAdaptador = new SeccionBAdaptador();
        this.jsonAfiliado = obtenerInformacion("src/test/resources/json/afiliado.json");
        this.jsonAfiliados = obtenerInformacion("src/test/resources/json/listaAfiliadosArray.json");
    }

    @Test()
    public void deserializarAfiliado() throws IOException {
        Afiliado afiliado = this.seccionBAdaptador.obtenerAfiliado(new JsonReader(new StringReader(this.jsonAfiliado)));

        assertNotNull(afiliado);
        assertEquals(afiliado.getTipoIdentificacion(), "CC");
        assertEquals(afiliado.getNumeroIdentificacion(), "1037622083");
        assertEquals(afiliado.getPrimerApellido(), "Garcia");
        assertEquals(afiliado.getPrimerNombre(), "Andersson");
        assertEquals(afiliado.getSegundoApellido(), "Sotelo");
        assertEquals(afiliado.getSegundoNombre(), null);
        assertEquals(afiliado.getDiasCotizados(), "3");
        assertEquals(afiliado.getSalarioBasico(), "1500000");
        assertEquals(afiliado.getCodigoEps(), null);
    }

    @Test(expected = NullPointerException.class)
    public void deserializarAfiliadoException() throws IOException {
        this.seccionBAdaptador.obtenerAfiliado(null);
    }

    @Test()
    public void deserializarListaAfiliados() {
        SeccionB seccionB = (SeccionB) Serializador.jsonAObjetoConAdaptador(this.jsonAfiliados, SeccionB.class,
                new SeccionBAdaptador());

        assertNotNull(seccionB);
        assertNotNull(seccionB.getAfiliados());
        assertTrue(seccionB.getAfiliados().size() == 3);
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
}
