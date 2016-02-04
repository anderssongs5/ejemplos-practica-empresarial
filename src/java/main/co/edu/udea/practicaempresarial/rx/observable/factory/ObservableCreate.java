package co.edu.udea.practicaempresarial.rx.observable.factory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class ObservableCreate {

    private static <T> Observable<T> desdeIterator(final Iterable<T> iterable) {
        return Observable.create(new OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> t) {
                try {
                    Iterator<T> iterator = iterable.iterator();
                    while (iterator.hasNext()) {
                        t.onNext(iterator.next());
                    }

                    t.onCompleted();
                } catch (Exception e) {
                    t.onError(e);
                }
            }

        });
    }

    public static void correr() {
        List<String> numeros = Arrays.asList("1", "2", "3", "4", "5");
        desdeIterator(numeros).subscribe(System.out::println);
    }
}
