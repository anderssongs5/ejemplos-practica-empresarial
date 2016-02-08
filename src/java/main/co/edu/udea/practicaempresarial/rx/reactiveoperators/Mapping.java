package co.edu.udea.practicaempresarial.rx.reactiveoperators;

import java.nio.file.Paths;

import co.edu.udea.practicaempresarial.rx.general.CreadorObservables;
import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;

public class Mapping {

    private static void map1() {
        System.out.println("Map1");
        Observable<String> mapped = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).map(v -> v * 3)
                .map(v -> (v % 2 == 0) ? "Par - " + v : "Impar - " + v);
        Helper.suscribirseImprimir(mapped, "Map1");
    }

    private static void flatMap1() {
        System.out.println("Flat Map 1");
        Observable<String> filesObservable = Helper
                .listarCarpetas(Paths.get("src", "java", "resources"), "{lorem.txt,letters.txt}")
                .flatMap(ruta -> CreadorObservables.from(ruta));
        Helper.suscribirseImprimir(filesObservable, "Archivos Observables");
    }

    /*
     * Se transforma los errores y eventos completados en Observables.
     */
    private static void flatMap2() {
        System.out.println("Flat Map 2");
        Observable<Integer> numerosObservables = Observable.just(-1, 0, 1).map(v -> 2 / v)
                .flatMap(v -> Observable.just(v), e -> Observable.just(0), () -> Observable.just(42));

        Helper.suscribirseImprimir(numerosObservables, "Números Observables");
    }

    private static void flatMap3() {
        System.out.println("Flat Map 3");
        Observable<Integer> numerosObservables = Observable.just(5, 432).flatMap(v -> Observable.range(v, 2),
                (x, y) -> x + y);
        Helper.suscribirseImprimir(numerosObservables, "Números Observables");
    }

    private static void flatMap4() {
        System.out.println("Flat Map 4");
        Observable<String> filesObservable = Helper
                .listarCarpetas(Paths.get("src", "java", "resources"), "{lorem.txt,letters.txt}")
                .flatMap(ruta -> CreadorObservables.from(ruta), (ruta, linea) -> ruta.getFileName() + " - " + linea);
        Helper.suscribirseImprimir(filesObservable, "Archivos Observables");
    }

    public static void main(String args[]) {
        map1();

        flatMap1();

        flatMap2();

        flatMap3();

        flatMap4();
    }
}
