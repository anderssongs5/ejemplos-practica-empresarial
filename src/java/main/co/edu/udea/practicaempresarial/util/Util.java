package co.edu.udea.practicaempresarial.util;

import java.util.Map;

public class Util {

    public static String convertirAJson(Map<String, String> campos) {
        String json = "";
        for (Map.Entry<String, String> entry : campos.entrySet()) {
            String campo = entry.getKey();
            String valor = entry.getValue();

            if (campo != null && !campo.trim().isEmpty() && valor != null) {
                json = json.concat("\"").concat(campo).concat("\":\"").concat(valor).concat("\",");
            }
        }

        json = "{".concat(json.substring(0, json.length() - 1)).concat("}");

        return json;
    }
}
