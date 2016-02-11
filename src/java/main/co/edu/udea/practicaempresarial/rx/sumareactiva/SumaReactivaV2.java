package co.edu.udea.practicaempresarial.rx.sumareactiva;

import java.util.regex.Pattern;

import co.edu.udea.practicaempresarial.rx.general.CreadorObservables;
import rx.Observable;
import rx.observables.ConnectableObservable;

public class SumaReactivaV2 {

    /*
     * Se retorna observable de valor que cumple con el formato: <varName> =
     * <value> o <varName> : <value>.
     */
    public static Observable<Double> obtenerValorStream(final String varName, Observable<String> input) {
        final Pattern pattern = Pattern.compile("^\\s*" + varName + "\\s*[:|=]\\s*(-?\\d+\\.?\\d*)$");

        return input.map(pattern::matcher).filter(m -> m.matches()).map(matcher -> matcher.group(1))
                .map(str -> Double.parseDouble(str));
    }

    public static void sumarReactivo(Observable<Double> a, Observable<Double> b) {
        Observable.combineLatest(a, b, (x, y) -> (x + y))
                .subscribe(sum -> System.out.println("Actualización: a + b = " + sum), error -> {
                    System.out.println("Se presentó error!");
                    error.printStackTrace();
                } , () -> System.out.println("Saliendo"));
    }

    public static void main(String args[]) {
        ConnectableObservable<String> input = CreadorObservables.from(System.in);

        Observable<Double> a = obtenerValorStream("a", input);
        Observable<Double> b = obtenerValorStream("b", input);

        sumarReactivo(a, b);

        input.connect();
    }
}
