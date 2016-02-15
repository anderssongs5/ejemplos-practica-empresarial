package co.edu.udea.practicaempresarial.rx.reactiveoperators;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;
import rx.schedulers.TimeInterval;
import rx.schedulers.Timestamped;

public class OtrosOperadoresTransformacion {

    private static List<Number> lista = Arrays.asList(1, 2, 3, 4, 5);

    private static void cast1() {
        System.out.println("Cast 1");
        Observable<Integer> observable = Observable.from(lista).cast(Integer.class);

        Helper.suscribirseImprimir(observable, "Observable de números casteados");
    }

    private static void timeStamp1() {
        System.out.println("Time Stamp 1");
        Observable<Timestamped<Number>> observable = Observable.from(lista).timestamp();

        Helper.suscribirseImprimir(observable, "Time Stamp");
    }

    @SuppressWarnings("deprecation")
    private static void timeInterval1() {
        System.out.println("Time Interval 1");
        Observable<TimeInterval<Long>> observable = Observable.timer(0L, 150L, TimeUnit.MILLISECONDS).timeInterval();

        Helper.suscribirseImprimir(observable, "Time Interval");
    }

    public static void main(String args[]) throws InterruptedException {
        cast1();

        timeStamp1();

        timeInterval1();
//        Thread.sleep(150);
    }
}
