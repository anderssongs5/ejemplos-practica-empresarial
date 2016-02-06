package co.edu.udea.practicaempresarial.rx.observable.factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.Observable.OnSubscribe;
import rx.schedulers.Schedulers;

public class EjemploConUnsubscribe {

    private static <T> Observable<T> desdeIterator2(final Iterable<T> iterable) {
        return Observable.create(new OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> t) {
                try {
                    Iterator<T> iterator = iterable.iterator();
                    while (iterator.hasNext()) {
                        if (t.isUnsubscribed()) {
                            return;
                        }

                        t.onNext(iterator.next());
                    }

                    if (!t.isUnsubscribed()) {
                        t.onCompleted();
                    }
                } catch (Exception e) {
                    if (!t.isUnsubscribed()) {
                        t.onError(e);
                    }
                }
            }

        });
    }

    private static <T> Subscription suscribirseImprimir(Observable<T> observable, String nombre) {
        return observable.subscribe((v) -> System.out.println(nombre + ": " + v), (e) -> {
            System.err.println("Error desde " + nombre + ":");
            System.err.println(e.getMessage());
        } , () -> System.out.println(nombre + " terminó!"));
    }

    public static void correr() {
        Path path = Paths.get("src", "java", "resources", "lorem_big.txt");
        List<String> filas = new ArrayList<>();
        try {
            filas = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Observable<String> numerosObservable = desdeIterator2(filas).subscribeOn(Schedulers.computation());
        Subscription subscription = suscribirseImprimir(numerosObservable, "Fila");
        System.out.println("Antes de 'unsubscribed'");
        System.out.println("------------------");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        subscription.unsubscribe();
        System.out.println("------------------");
        System.out.println("Después de 'unsubscribed'");
    }
}
