package co.edu.udea.practicaempresarial.rx.general;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class Helper {

    public static <T> Subscription suscribirseImprimir(Observable<T> observable, String nombre) {
        return observable.subscribe((v) -> System.out.println(nombre + ": " + v), (e) -> {
            System.err.println("Error desde " + nombre + ":");
            System.err.println(e.getMessage());
        } , () -> System.out.println(nombre + " terminó!"));
    }

    public static Observable<Path> listarCarpetas(Path directorio, String glob) {
        return Observable.<Path> create(subscriber -> {
            try {
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directorio, glob);
                // Se ejecuta cuando la instancia Subscription de desinscribe
                subscriber.add(Subscriptions.create(() -> {
                    try {
                        directoryStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }));

                Observable.<Path> from(directoryStream).subscribe(subscriber);
            } catch (DirectoryIteratorException | IOException e) {
                subscriber.onError(e);
            }
        });
    }
}
