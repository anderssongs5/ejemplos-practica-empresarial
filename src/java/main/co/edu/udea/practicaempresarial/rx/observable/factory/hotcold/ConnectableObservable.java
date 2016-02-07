package co.edu.udea.practicaempresarial.rx.observable.factory.hotcold;

import java.util.concurrent.TimeUnit;

import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;
import rx.Subscription;

/*
 * El Observable de tipo ConnectableObservable se mantiene inactivo hasta que
 * el método connect() se llama, por lo que se convierte en "hot observable".
 * 
 * El método publish() puede convertir cualquier "cold observable" en un
 * "hot observable".
 * */
public class ConnectableObservable {

    /*
     * Se crea un observable de intervao y a partir de él, un
     * ConnectableObservable. Se hacen dos suscripciones y se inicia a emitir
     * notificaciones llamando el método connect(), por lo que los dos primeros
     * suscriptores reciben las mismas notificaciones. Después de una
     * interrupción del hilo principal, se realiza una tercera suscripción, para
     * la cual solo recibe notificaciones a partir de ese momento y las
     * anteriores a ese momento no llevadas a él, es decir, no se le notifican.
     */
    private static void connectableObservable1() {
        Observable<Long> intervalo = Observable.interval(100L, TimeUnit.MILLISECONDS);
        rx.observables.ConnectableObservable<Long> connectableObservable = intervalo.publish();
        Subscription subscription1 = Helper.suscribirseImprimir(connectableObservable, "Primero1");
        Subscription subscription2 = Helper.suscribirseImprimir(connectableObservable, "Segundo1");
        connectableObservable.connect();

        Subscription subscription3 = null;
        try {
            Thread.sleep(500L);
            subscription3 = Helper.suscribirseImprimir(connectableObservable, "Tercero1");
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subscription1.unsubscribe();
        subscription2.unsubscribe();
        subscription3.unsubscribe();
    }

    /*
     * Se activa el observable desde el inicio. Se hacen dos suscripciones,
     * cuyos subscriptores reciben las mismas notificaciones y se interrumpe el
     * hilo principal para luego desinscribirse. Posteriormente se hace una
     * tercer suscripción, a cuyo subscriptor se le notifica desde el inicio, es
     * decir, vuelve a empezar desde 0.
     */
    private static void connectableObservable2() {
        Observable<Long> intervalo = Observable.interval(100L, TimeUnit.MILLISECONDS);
        Observable<Long> connectableObservable = intervalo.publish().refCount();
        Subscription subscription1 = Helper.suscribirseImprimir(connectableObservable, "Primero2");
        Subscription subscription2 = Helper.suscribirseImprimir(connectableObservable, "Segundo2");

        try {
            Thread.sleep(300L);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        subscription1.unsubscribe();
        subscription2.unsubscribe();

        Subscription subscription3 = Helper.suscribirseImprimir(connectableObservable, "Tercero2");
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subscription3.unsubscribe();
    }

    /*
     * Se activa el observable desde el inicio. Se hace una suscripción, cuyo
     * subscriptor recibe notificaciones y se interrumpe el hilo principal para
     * luego realizar una segunda suscripción. El segundo suscriptor no recibe
     * las primeras notificaciones que recibió el primer suscriptor debido a que
     * es un observable tipo "hot". Después se desincriben los dos primeros
     * subcritores. Posteriormente se hace una tercer suscripción, a cuyo
     * subscriptor se le notifica desde el inicio, es decir, vuelve a empezar
     * desde 0.
     */
    private static void connectableObservable3() {
        Observable<Long> intervalo = Observable.interval(100L, TimeUnit.MILLISECONDS);
        Observable<Long> connectableObservable = intervalo.publish().refCount();
        Subscription subscription1 = Helper.suscribirseImprimir(connectableObservable, "Primero3");

        try {
            Thread.sleep(300L);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        Subscription subscription2 = Helper.suscribirseImprimir(connectableObservable, "Segundo3");

        try {
            Thread.sleep(300L);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        subscription1.unsubscribe();
        subscription2.unsubscribe();

        Subscription subscription3 = Helper.suscribirseImprimir(connectableObservable, "Tercero3");
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subscription3.unsubscribe();
    }

    public static void correr() {
        connectableObservable1();

        connectableObservable2();

        connectableObservable3();
    }
}
