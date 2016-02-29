package co.edu.udea.practicaempresarial.rx.reactiveoperators;

import java.util.Arrays;
import java.util.List;

import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;

public class Filtering {

    private static List<Integer> numbers = Arrays.asList(1, 13, 32, 45, 21, 8, 98, 103, 55, 776);

    private static void filtering1() {
        System.out.println("Filtering 1");
        Observable<Integer> numeros = Observable.from(numbers);
        Observable<Integer> filtrado = numeros.filter(n -> n % 2 == 0);
        Helper.suscribirseImprimir(filtrado, "Filtering");
    }

    private static void otherFilteringMethods() {
        System.out.println("Filtering 2");
        Observable<Integer> numeros = Observable.from(numbers);
        Observable<String> palabras = Observable.just("One", "of", "the", "few", "of", "the", "crew", "crew");
        Observable<?> varios = Observable.from(Arrays.asList("1", 2, 3.5, 4, 5L));

        Helper.suscribirseImprimir(numeros.takeLast(4), "Take Last - Numbers");
        Helper.suscribirseImprimir(numeros.last(), "Last - Numbers");
        Helper.suscribirseImprimir(numeros.takeLastBuffer(4), "Take Last Buffer - Numbers");
        Helper.suscribirseImprimir(numeros.lastOrDefault(-1), "Last Or Default 1 - Numbers");
        Helper.suscribirseImprimir(Observable.empty().lastOrDefault(-1), "Last Or Default 2 - Numbers");
        Helper.suscribirseImprimir(numeros.skipLast(9), "Skip Last - Numbers");
        Helper.suscribirseImprimir(numeros.elementAt(4), "Element At - Numbers");
        Helper.suscribirseImprimir(numeros.elementAtOrDefault(20, -1), "Element At or Default - Numbers");

        System.out.println("-------------------------------------------------------------------------");

        Helper.suscribirseImprimir(palabras.skip(6), "Skip - Words");
        Helper.suscribirseImprimir(palabras.firstOrDefault("Default word"), "First or Default 1 - Words");
        Helper.suscribirseImprimir(Observable.empty().firstOrDefault("Default word"), "First or Default 2 - Words");
        Helper.suscribirseImprimir(palabras.distinct(), "Distinct - Words");
        Helper.suscribirseImprimir(palabras.distinctUntilChanged(), "Distinct Until Changed");

        System.out.println("-------------------------------------------------------------------------");

        Helper.suscribirseImprimir(varios.take(3), "Take - Various");
        Helper.suscribirseImprimir(varios.first(), "First - Various");
        Helper.suscribirseImprimir(varios.ofType(Long.class), "Of Type - Various");
        Helper.suscribirseImprimir(varios.filter(v -> v instanceof Long), "Instance of - Various");
    }

    public static void main(String args[]) {
        filtering1();

        otherFilteringMethods();
    }
}
