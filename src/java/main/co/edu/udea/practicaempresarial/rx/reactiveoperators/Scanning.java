package co.edu.udea.practicaempresarial.rx.reactiveoperators;

import java.nio.file.Paths;

import co.edu.udea.practicaempresarial.rx.general.CreadorObservables;
import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;

public class Scanning {

    private static void scan1() {
        System.out.println("Scan 1");
        Observable<Integer> scan = Observable.range(1, 10).scan((v, p) -> v + p);
        Helper.suscribirseImprimir(scan, "Scan");
        Helper.suscribirseImprimir(scan.first(), "Scan First");
        Helper.suscribirseImprimir(scan.last(), "Scan Last");
    }

    /*
     * Usar reduce es lo mismo que hacer scan(Func2).last()
     */
    private static void reduce1() {
        System.out.println("Reduce 1");
        Observable<Integer> scan = Observable.range(1, 10).reduce((v, p) -> v + p);
        Helper.suscribirseImprimir(scan, "Reduce");
    }

    private static void scan2() {
        System.out.println("Scan 2");
        Observable<String> file = CreadorObservables.from(Paths.get("src", "java", "resources", "letters.txt"));
        Observable<Integer> scan = file.scan(0, (p, v) -> p + 1);
        Helper.suscribirseImprimir(scan, "Scan Initial Value");
    }

    public static void main(String args[]) {
        scan1();

        reduce1();

        scan2();
    }
}
