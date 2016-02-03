package co.edu.udea.practicaempresarial.rx.observable.factory;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class OtherObservableFactoryMethods {

    public static <T> void suscribirseImprimir(Observable<T> observable, String nombre) {
        observable.subscribe((v) -> System.out.println(nombre + ": " + v), (e) -> {
            System.err.println("Error desde " + nombre + ":");
            System.err.println(e.getMessage());
        } , () -> System.out.println(nombre + " termin�!"));
    }

    @SuppressWarnings("deprecation")
    public static void correr() throws InterruptedException {
        /*
         * Con Observable.interval se obtiene un observable que emite un n�mero
         * secuencial cada intervalo de tiempo especificado.
         */
        suscribirseImprimir(Observable.interval(100L, TimeUnit.MILLISECONDS), "Intervalo observable");

        /*
         * Observable.timer(?, ?, ?) devuelve un observable que emite un 0
         * despu�s del retardo inicial y cada vez m�s n�meros despu�s de cada
         * per�odo de tiempo a partir de entonces.
         */
        suscribirseImprimir(Observable.timer(0L, 1L, TimeUnit.SECONDS), "Observable de intervalo de tiempo");

        /*
         * Observable.timer(?, ?) retorna un observable que emite un �tem
         * despu�s del retardo especificado, y luego finaliza.
         */
        suscribirseImprimir(Observable.timer(1L, TimeUnit.SECONDS), "Observable timer");

        /*
         * Observable.error retorna un observable que invoca el m�todo de error
         * (onError) del observador cuando el observador se suscribe a �l.
         */
        suscribirseImprimir(Observable.error(new Exception("Error de prueba!")), "Observable error");

        /*
         * Observer.empty devuelve un observable que no emite �tems e
         * inmediatamente llama el m�todo onCompleted
         */
        suscribirseImprimir(Observable.empty(), "Observable vac�o");

        /*
         * Observer.never retorna un observable que nunca emite �tems.
         */
        suscribirseImprimir(Observable.never(), "Observable nunca");

        /*
         * Observable.range retorna un observable que emite una secuencia de
         * n�meros enteros dentro de un rango especificado.
         */
        suscribirseImprimir(Observable.range(1, 3), "Observable de rango");

        Thread.sleep(5000L);
    }
}
