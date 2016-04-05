package co.edu.udea.practicaempresarial.rx.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.observables.ConnectableObservable;
import rx.subscriptions.Subscriptions;

public class CreadorObservables {

    public static ConnectableObservable<String> from(final InputStream stream) {
        return from(new BufferedReader(new InputStreamReader(stream)));
    }

    public static ConnectableObservable<String> from(final BufferedReader reader) {

        return Observable.create(new OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }

                try {
                    String line;
                    while (!subscriber.isUnsubscribed() && (line = reader.readLine()) != null) {
                        if (line.equals("exit")) {
                            break;
                        }
                        subscriber.onNext(line);
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }

                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }
            }
        }).publish();
    }

    public static Observable<String> from(final Path path) {
        return Observable.<String> create(subscriber -> {
            try {
                BufferedReader bufferedReader = Files.newBufferedReader(path);
                subscriber.add(Subscriptions.create(() -> {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }));

                String line = null;
                while ((line = bufferedReader.readLine()) != null && !subscriber.isUnsubscribed()) {
                    subscriber.onNext(line);
                }

                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }
            } catch (IOException e) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
