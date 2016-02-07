package co.edu.udea.practicaempresarial.rx.general;

import rx.Observable;
import rx.Subscription;

public class Helper {

    public static <T> Subscription suscribirseImprimir(Observable<T> observable, String nombre) {
        return observable.subscribe((v) -> System.out.println(nombre + ": " + v), (e) -> {
            System.err.println("Error desde " + nombre + ":");
            System.err.println(e.getMessage());
        } , () -> System.out.println(nombre + " terminó!"));
    }
}
