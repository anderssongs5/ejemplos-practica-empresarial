package co.edu.udea.practicaempresarial.rx;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import rx.Observable;

/*
 * Creación de observables usando método from con el
 * objetivo de crear observables a partir de otras fuentes.
 * Se crean los observables a partir de objetos que
 * implementan Iterable.
 * */
public class ObservableFrom {

    private static void crearDesdeLista() {
        List<String> colors = Arrays.asList("Azul", "Rojo", "Verde", "Amarillo", "Naranja", "Gris", "Púrpura");
        Observable<String> observableColors = Observable.from(colors);

        observableColors.subscribe(System.out::println);
    }

    private static void crearDesdePath() {
        Path resources = Paths.get("src", "java", "resources");

        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(resources);
            Observable<Path> directoryObservable = Observable.from(directoryStream);
            directoryObservable.subscribe(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void crearDesdeArreglo() {
        Observable<Integer> numbersObservable = Observable.from(new Integer[] { 3, 5, 8 });

        numbersObservable.subscribe(System.out::println);
    }

    public static void correr() {
        crearDesdeLista();

        crearDesdePath();

        crearDesdeArreglo();
    }
}
