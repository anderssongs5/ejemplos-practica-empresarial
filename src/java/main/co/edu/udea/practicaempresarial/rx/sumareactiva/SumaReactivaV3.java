package co.edu.udea.practicaempresarial.rx.sumareactiva;

import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class SumaReactivaV3 {

    static class SumaReactivaBehaviorSubject {

        private BehaviorSubject<Double> a = BehaviorSubject.create(0.0);
        private BehaviorSubject<Double> b = BehaviorSubject.create(0.0);
        private BehaviorSubject<Double> c = BehaviorSubject.create(0.0);

        public SumaReactivaBehaviorSubject() {
            super();
            Observable.combineLatest(a, b, (x, y) -> (x + y)).subscribe(c);
        }

        public double getA() {
            return a.getValue();
        }

        public void setA(double a) {
            this.a.onNext(a);
        }

        public double getB() {
            return b.getValue();
        }

        public void setB(double b) {
            this.b.onNext(b);
        }

        public double getC() {
            return c.getValue();
        }

        public Observable<Double> obsC() {
            return this.c.asObservable();
        }
    }

    public static void main(String args[]) {
        SumaReactivaBehaviorSubject sumaReactiva = new SumaReactivaBehaviorSubject();

        Helper.suscribirseImprimir(sumaReactiva.obsC(), "Suma Reactiva");
        sumaReactiva.setA(4.0);
        sumaReactiva.setB(10.3);

        sumaReactiva.setB(5.0);
        sumaReactiva.setA(-10.0);
    }
}
