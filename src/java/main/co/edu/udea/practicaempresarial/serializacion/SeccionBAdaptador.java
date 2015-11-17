package co.edu.udea.practicaempresarial.serializacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import co.edu.udea.practicaempresarial.modelo.Afiliado;
import co.edu.udea.practicaempresarial.modelo.SeccionB;

public class SeccionBAdaptador extends TypeAdapter<SeccionB> {

    @Override
    public void write(JsonWriter out, SeccionB value) throws IOException {
    }

    @Override
    public SeccionB read(JsonReader in) throws IOException {
        SeccionB seccionB = new SeccionB();
        List<Afiliado> afiliados = new ArrayList<>();

        in.beginObject();
        while (in.hasNext()) {
            in.nextName();
            in.beginArray();
            while (in.hasNext()) {
                afiliados.add(obtenerAfiliado(in));
            }
            in.endArray();
        }
        in.endObject();

        seccionB.setAfiliados(afiliados);

        return seccionB;
    }

    public Afiliado obtenerAfiliado(JsonReader in) throws IOException {
        Afiliado afiliado = new Afiliado();

        in.beginObject();
        while (in.hasNext()) {
            String name = in.nextName();
            switch (name) {
            case "numeroIdentificacion":
                afiliado.setNumeroIdentificacion(in.nextString());
                break;
            case "tipoIdentificacion":
                afiliado.setTipoIdentificacion(in.nextString());
                break;
            case "primerApellido":
                afiliado.setPrimerApellido(in.nextString());
                break;
            case "segundoApellido":
                afiliado.setSegundoApellido(in.nextString());
                break;
            case "primerNombre":
                afiliado.setPrimerNombre(in.nextString());
                break;
            case "segundoNombre":
                afiliado.setSegundoNombre(in.nextString());
                break;
            case "diasCotizados":
                afiliado.setDiasCotizados(in.nextString());
                break;
            case "salarioBasico":
                afiliado.setSalarioBasico(in.nextString());
                break;
            case "codigoEps":
                afiliado.setCodigoEps(in.nextString());
            }
        }
        in.endObject();

        return afiliado;
    }

}
