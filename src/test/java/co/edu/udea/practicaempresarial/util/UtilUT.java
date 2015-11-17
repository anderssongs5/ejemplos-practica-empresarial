package co.edu.udea.practicaempresarial.util;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class UtilUT {

    private Map<String, String> mapa;
    String seccionCJson;

    @Before()
    public void inicializacion() {
        this.mapa = new LinkedHashMap<String, String>();
        mapa.put("cotizacionObligatoria", "150000");
        mapa.put("totalDescuentos", "30000");
        mapa.put("numeroDiasMora", "0");
        mapa.put("totalNetoAportes", "120000");

        this.seccionCJson = "{\"cotizacionObligatoria\":\"150000\",\"totalDescuentos\":\"30000\","
                + "\"numeroDiasMora\":\"0\",\"totalNetoAportes\":\"120000\"}";
    }

    @Test()
    public void convertirAJson() {
        Map<String, String> map = this.mapa;
        String seccionCSerializada = Util.convertirAJson(map);

        assertEquals(this.seccionCJson, seccionCSerializada);
    }

    @Test()
    public void convertirAJsonCampoNulo() {
        Map<String, String> map = this.mapa;
        map.put(null, "campoNulo");
        String seccionCSerializada = Util.convertirAJson(map);

        assertEquals(this.seccionCJson, seccionCSerializada);
    }

    @Test()
    public void convertirAJsonCampoVacio() {
        Map<String, String> map = this.mapa;
        map.put("", "campoVacio");
        String seccionCSerializada = Util.convertirAJson(map);

        assertEquals(this.seccionCJson, seccionCSerializada);
    }

    @Test()
    public void convertirAJsonValorNulo() {
        Map<String, String> map = this.mapa;
        map.put("valorNulo", null);
        String seccionCSerializada = Util.convertirAJson(map);

        assertEquals(this.seccionCJson, seccionCSerializada);
    }

    @Test()
    public void convertirAJsonCampoNuloYValorNulo() {
        Map<String, String> map = this.mapa;
        map.put(null, null);
        String seccionCSerializada = Util.convertirAJson(map);

        assertEquals(this.seccionCJson, seccionCSerializada);
    }

    @Test()
    public void convertirAJsonCampoVacioYValorNulo() {
        Map<String, String> map = this.mapa;
        map.put("", null);
        String seccionCSerializada = Util.convertirAJson(map);

        assertEquals(this.seccionCJson, seccionCSerializada);
    }
}
