package co.edu.udea.practicaempresarial.rx.observable.factory;

import rx.Observable;

/*
 * Creación de observables utilizando método just.
 * Se convierten los ítems pasados como parámetros
 * en un Observable.
 * */
public class ObservableJust {

    private static class Usuario {

        private final String nombre;
        private final String apellidos;

        public Usuario(String nombre, String apellidos) {
            super();
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellidos() {
            return apellidos;
        }
    }

    private static void emitirLetra() {
        Observable.just('S').subscribe(System.out::println);
    }

    private static void emitirLetras() {
        Observable.just("R", "x", "J", "a", "v", "a").subscribe(System.out::print, System.out::println,
                System.out::println);
    }

    private static void pintarUsuario() {
        Observable.just(new Usuario("Andersson", "García Sotelo")).map(u -> u.getNombre() + " " + u.getApellidos())
                .subscribe(System.out::println);
    }

    public static void correr() {
        emitirLetra();

        emitirLetras();

        pintarUsuario();
    }
}
