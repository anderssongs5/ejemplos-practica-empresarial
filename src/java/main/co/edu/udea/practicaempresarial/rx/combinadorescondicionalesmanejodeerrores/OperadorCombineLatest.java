package co.edu.udea.practicaempresarial.rx.combinadorescondicionalesmanejodeerrores;

import java.util.concurrent.TimeUnit;

import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;

/*
 * combineLatest() combina los últimos valores emitidos por las fuentes.
 * Todas las fuentes tienen que emitir algo para poder combinarlas y
 * empezar a emitirlas.
 */
public class OperadorCombineLatest {

    private static void combineLatest1() {
        System.out.println("Combine Latest 1");
        Observable<String> greetings = Observable.just("Hello", "Hi", "Howdy", "Zdravei", "Yo", "Good to see ya")
                .zipWith(Observable.interval(1L, TimeUnit.SECONDS), OperadorCombineLatest::onlyFirstArg);
        Observable<String> names = Observable.just("Meddle", "Tanya", "Dali", "Joshua")
                .zipWith(Observable.interval(1500L, TimeUnit.MILLISECONDS), OperadorCombineLatest::onlyFirstArg);
        Observable<String> punctuation = Observable.just(".", "?", "!", "!!!", "...")
                .zipWith(Observable.interval(1100L, TimeUnit.MILLISECONDS), OperadorCombineLatest::onlyFirstArg);

        Observable<String> combined = Observable.combineLatest(greetings, names, punctuation,
                (g, n, p) -> g + " " + n + p);
        Helper.suscribirseImprimir(combined, "Sentences 1");

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void combineLatest2() {
        System.out.println("Combine Latest 2");
        Observable<String> greetings = Observable.just("Hello", "Hi", "Howdy", "Zdravei", "Yo", "Good to see ya")
                .zipWith(Observable.interval(1L, TimeUnit.SECONDS), OperadorCombineLatest::onlyFirstArg);
        Observable<String> names = Observable.empty();
        Observable<String> punctuation = Observable.just(".", "?", "!", "!!!", "...")
                .zipWith(Observable.interval(1100L, TimeUnit.MILLISECONDS), OperadorCombineLatest::onlyFirstArg);

        Observable<String> combined = Observable.combineLatest(greetings, names, punctuation,
                (g, n, p) -> g + " " + n + p);
        Helper.suscribirseImprimir(combined, "Sentences 2");

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static <T, R> T onlyFirstArg(T arg1, R arg2) {
        return arg1;
    }

    public static void main(String args[]) {
        combineLatest1();

        combineLatest2();
    }
}
