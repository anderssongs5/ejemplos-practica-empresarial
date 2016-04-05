package co.edu.udea.practicaempresarial.rx;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class EjemplosObservables {

    private static List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five");

    /*
     * Ejemplo donde se crea un observable a partir de una lista. Se le dice a
     * RxJava que estamos interesados en ese observable y que se quieren recibir
     * notificaciones del mismo.
     */
    public static void ejemplo0() {
        Observable<String> observable = Observable.from(list);
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String t) {
                System.out.println(t);
            }

        });
    }

    // En este ejemplo se crean observables a partir de una lista
    // Se implementan métodos para poder notificar cuando
    // finaliza la operación o cuando se produce un error.
    public static void ejemplo1() {

        Observable<String> observable = Observable.from(list);
        observable.subscribe(
                // Se ejecuta cada vez que se tiene un valor,
                // listo para ser empujado o notificado
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
                        System.out.println("Hemos terminado!");
                    }
                });
    }

    public static void main(String args[]) {
        EjemplosObservables.ejemplo0();

        EjemplosObservables.ejemplo1();
    }
}
