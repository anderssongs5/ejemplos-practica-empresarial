package co.edu.udea.practicaempresarial.rx.combinadorescondicionalesmanejodeerrores;

import java.util.concurrent.TimeUnit;

import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;

public class OperadorZip {

    private static void zip1() {
        System.out.println("Zip 1");
        Observable<Integer> zip = Observable.zip(Observable.just(1, 3, 5), Observable.just(5, 2, 6), (a, b) -> a + b);
        Helper.suscribirseImprimir(zip, "Zip 1");
    }

    private static void zip2() {
        System.out.println("Zip 2");
        Observable<String> timedZip = Observable.zip(Observable.just("Z", "I", "P", "P"),
                Observable.interval(300L, TimeUnit.MILLISECONDS), (v, i) -> v + " " + i);
        Helper.suscribirseImprimir(timedZip, "Zip 2");
        try {
            Thread.sleep(1300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void zip3() {
        System.out.println("Zip 3");
        Observable<String> timedZip = Observable.just("Z", "I", "P", "P")
                .zipWith(Observable.interval(300L, TimeUnit.MILLISECONDS), (v, i) -> v + " " + i);
        Helper.suscribirseImprimir(timedZip, "ZipWith");
        try {
            Thread.sleep(1300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        zip1();

        zip2();

        zip3();
    }
}
