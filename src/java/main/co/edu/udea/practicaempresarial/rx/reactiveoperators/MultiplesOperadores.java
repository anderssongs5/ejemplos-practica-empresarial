package co.edu.udea.practicaempresarial.rx.reactiveoperators;

import java.beans.Introspector;
import java.nio.file.Paths;

import co.edu.udea.practicaempresarial.rx.general.CreadorObservables;
import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;

public class MultiplesOperadores {

    public static void main(String args[]) {
        Observable<String> file = CreadorObservables.from(Paths.get("src", "java", "resources", "operadores.txt"));
        Observable<String> f = file.flatMap(line -> Observable.from(line.split("\\."))).map(String::trim)
                .map(s -> s.split(" ")).filter(a -> a.length > 0).map(a -> a[0]).distinct()
                .groupBy(a -> a.contains("'")).flatMap(o -> o.getKey() ? o : o.map(Introspector::decapitalize))
                .map(String::trim).filter(w -> !w.isEmpty()).scan((a, b) -> a + " " + b).last().map(s -> s + ".");

        Helper.suscribirseImprimir(f, "Múltiples Operadores");

        System.out.println("\n-------------------------------------------------------------------------\n");

        Observable<String> f1 = file.flatMap(line -> Observable.from(line.split("\\."))).map(String::trim);
        Helper.suscribirseImprimir(f1, "F1");

        Observable<String> f2 = f1.map(s -> s.split(" ")).map(a -> a[0]);
        Helper.suscribirseImprimir(f2, "F2");

        Observable<String> f3 = f2.distinct();
        Helper.suscribirseImprimir(f3, "F3");

        Observable<String> f4 = f3.groupBy(a -> a.contains("'"))
                .flatMap(o -> o.getKey() ? o : o.map(Introspector::decapitalize));
        Helper.suscribirseImprimir(f4, "F4");

        Observable<String> f5 = f4.map(String::trim);
        Helper.suscribirseImprimir(f5, "F5");

        Observable<String> f6 = f5.scan((a, b) -> a + " " + b);
        Helper.suscribirseImprimir(f6, "F6");

        Observable<String> f7 = f6.last();
        Helper.suscribirseImprimir(f7, "F7");

        Observable<String> f8 = f7.map(t -> t + ".");
        Helper.suscribirseImprimir(f8, "F8");
    }
}
