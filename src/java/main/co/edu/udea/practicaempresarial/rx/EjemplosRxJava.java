package co.edu.udea.practicaempresarial.rx;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class EjemplosRxJava {

    public static void ejemplo1() {
        // En este ejemplo se crean observables a partir de una lista
        // Se implementan métodos para poder notificar cuando
        // finaliza la operación o cuando se produce un error.
        List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five");

        Observable<String> observable = Observable.from(list);
        observable.subscribe(
                // Se ejecuta cada vez que se tiene un valor,
                // listo para ser empujado o nitificado
                new Action1<String>() {
                    @Override()
                    public void call(String element) {
                        System.out.println(element);
                    }
                },
                // Notifica cuando ocurre un error
                new Action1<Throwable>() {
                    @Override
                    public void call(Throwable t) {
                        System.err.println(t);
                    }
                },
                // Notifica cuando se completa la operación, es decir,
                // cuando no hay más elementos por procesar o notificar.
                new Action0() {
                    @Override
                    public void call() {
                        System.out.println("We've finnished!");
                    }
                });
    }
}
