package co.edu.udea.practicaempresarial.serializacion;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Serializador {

    // Utilizado para imprimir JSON más vistoso
    // Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String objetoAJson(Object object) {
        Gson gson = new Gson();

        return gson.toJson(object);
    }

    public static String objetoAJson(Object object, String dateFormat) {
        Gson gson = new GsonBuilder().setDateFormat(dateFormat).create();

        return gson.toJson(object);
    }

    public static Object jsonAObjeto(String json, Class<?> classOfT) {
        Gson gson = new Gson();

        return gson.fromJson(json, classOfT);
    }

    public static Object jsonAObjeto(String json, Class<?> classOfT, String dateFormat) {
        Gson gson = new GsonBuilder().setDateFormat(dateFormat).create();

        return gson.fromJson(json, classOfT);
    }

    public static List<Object> jsonAObjeto(String json, Type typeOfT) {
        Gson gson = new Gson();

        return gson.fromJson(json, typeOfT);
    }

    public static Object jsonAObjetoConAdaptador(String json, Class<?> classOfT, Object adapter) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(classOfT, adapter);
        Gson gson = gsonBuilder.create();

        return gson.fromJson(json, classOfT);
    }
}
