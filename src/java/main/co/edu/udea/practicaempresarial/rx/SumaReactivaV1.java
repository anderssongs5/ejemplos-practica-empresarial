package co.edu.udea.practicaempresarial.rx;

import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.udea.practicaempresarial.rx.general.CreadorObservables;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

public class SumaReactivaV1 {

    public static final class SumaR implements Observer<Double> {

        private CountDownLatch latch = new CountDownLatch(1);

        private double suma;
        private Subscription subscription = null;

        public SumaR(Observable<Double> a, Observable<Double> b) {
            this.suma = 0;

            subscribe(a, b);
        }

        private void subscribe(Observable<Double> a, Observable<Double> b) {
            this.subscription = Observable.combineLatest(a, b, new Func2<Double, Double, Double>() {
                public Double call(Double a, Double b) {
                    return a + b;
                }
            }).subscribeOn(Schedulers.io()).subscribe(this);
        }

        public void unsubscribe() {
            this.subscription.unsubscribe();
            this.latch.countDown();
        }

        public void onCompleted() {
            System.out.println("La última suma fue : " + this.suma);
            this.latch.countDown();
        }

        public void onError(Throwable e) {
            System.err.println("Error!");
            e.printStackTrace();
        }

        public void onNext(Double sum) {
            this.suma = sum;
            System.out.println("Actualizado: a + b = " + sum);
        }

        public CountDownLatch getLatch() {
            return latch;
        }
    }

    /*
     * Se retorna observable de valor que cumple con el formato: <varName> =
     * <value> o <varName> : <value>.
     */
    public static Observable<Double> obtenerValorStream(final String varName, Observable<String> input) {
        final Pattern pattern = Pattern.compile("^\\s*" + varName + "\\s*[:|=]\\s*(-?\\d+\\.?\\d*)$");

        return input.map(new Func1<String, Matcher>() {
            public Matcher call(String str) {
                return pattern.matcher(str);
            }
        }).filter(new Func1<Matcher, Boolean>() {
            public Boolean call(Matcher matcher) {
                return matcher.matches();
            }
        }).map(new Func1<Matcher, String>() {
            public String call(Matcher matcher) {
                return matcher.group(1);
            }
        }).map(new Func1<String, Double>() {
            public Double call(String str) {
                return Double.parseDouble(str);
            }
        });
    }

    public static void correr() {
        ConnectableObservable<String> input = CreadorObservables.from(System.in);

        Observable<Double> a = obtenerValorStream("a", input);
        Observable<Double> b = obtenerValorStream("b", input);

        SumaR sumaReactiva = new SumaR(a, b);

        input.connect();

        try {
            sumaReactiva.getLatch().await();
        } catch (InterruptedException e) {
        }
    }
}
