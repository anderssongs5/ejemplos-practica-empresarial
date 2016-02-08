package co.edu.udea.practicaempresarial.rx.subject;

import java.util.concurrent.TimeUnit;

import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

public class SubjectExample {

    /*
     * El Subject cuando es tratado como un observable funciona como si fuera un
     * observable "hot". Un PublishSubject se comporta similar a un
     * ConnectableObservable.
     */
    private static void subjectAsObservable1() {
        Observable<Long> intervalo = Observable.interval(100L, TimeUnit.MILLISECONDS);
        Subject<Long, Long> publishSubject = PublishSubject.create();
        intervalo.subscribe(publishSubject);
        Subscription subscription1 = Helper.suscribirseImprimir(publishSubject, "Primero1");
        Subscription subscription2 = Helper.suscribirseImprimir(publishSubject, "Segundo1");

        Subscription subscription3 = null;
        try {
            Thread.sleep(300L);
            publishSubject.onNext(555L);
            subscription3 = Helper.suscribirseImprimir(publishSubject, "Tercero1");
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        publishSubject.onNext(100L);

        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subscription1.unsubscribe();
        subscription2.unsubscribe();
        subscription3.unsubscribe();
    }

    public static void correr() {
        subjectAsObservable1();
    }
}
