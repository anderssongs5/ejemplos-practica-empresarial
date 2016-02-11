package co.edu.udea.practicaempresarial.rx.reactiveoperators;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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

    private static void flatIterableMapped1() {
        System.out.println("Flat Iterable Mapped 1");
        Observable<?> flatIterableMapped = Observable.just(Arrays.asList(2, 4), Arrays.asList("Dos", "Cuatro"))
                .flatMapIterable(n -> n);
        Helper.suscribirseImprimir(flatIterableMapped, "Flat Iterable Mapped");
    }

    private static void flatIterableMapped2() {
        System.out.println("Flat Iterable Mapped 2");
        Observable<?> flatIterableMapped = Observable.just(Arrays.asList(2, 4), Arrays.asList("Dos", "Cuatro"))
                .flatMap(n -> Observable.from(n));
        Helper.suscribirseImprimir(flatIterableMapped, "Flat Iterable Mapped");
    }

    private static void concatMap1() {
        System.out.println("Concat Map 1");
        Observable<String> concatMapped = Helper
                .listarCarpetas(Paths.get("src", "java", "resources"), "{lorem.txt,letters.txt}")
                .concatMap(ruta -> CreadorObservables.from(ruta));
        Helper.suscribirseImprimir(concatMapped, "Concat Map");
    }

    @SuppressWarnings("deprecation")
    private static void switchMap1() {
        System.out.println("Switch Map 1");
        Observable<String> switchMap = Observable.interval(40L, TimeUnit.MILLISECONDS).switchMap(v -> Observable
                .timer(0L, 10L, TimeUnit.MILLISECONDS).map(n -> ("Observable <" + (v + 1) + "> : " + (v + n))));

        Helper.suscribirseImprimir(switchMap, "Switch Map");
    }

    public static void main(String args[]) throws InterruptedException {
        map1();

        flatMap1();

        flatMap2();

        flatMap3();

        flatMap4();

        flatIterableMapped1();

        Thread.sleep(2000);

        flatIterableMapped2();

        Thread.sleep(2000);

        concatMap1();

        switchMap1();

        Thread.sleep(5000);
    }
}
