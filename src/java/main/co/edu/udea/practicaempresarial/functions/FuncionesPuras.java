package co.edu.udea.practicaempresarial.functions;

import java.util.function.Predicate;

public class FuncionesPuras {

    private static void pureEven() {
        Predicate<Integer> even = value -> (value % 2 == 0);
        int i = 50;
        while ((i--) > 0) {
            System.out.println("Es par? : " + even.test(5));
        }
    }

    /*
     * Una función pura es aquella que no tiene efectos secundarios y su valor
     * de retorno está solo determinado por su entrada.
     * 
     * Un efecto secundario es cualquier posible salida observable que una
     * función puede producir, por ejemplo, provocar eventos o lanzar
     * excepciones y I/O, diferente de su valor de retorno. Un efecto secundario
     * también cambia estados compartidos o argumentos mutables.
     * 
     * La siguiente función es no pura porque imprime un mensaje cada vez que es
     * llamada. Así, ésta hace dos cosas: prueba si el número es par, e imprime
     * un mensaje como un efecto secundario.
     */
    private static void impureEven() {
        Predicate<Integer> even = (number) -> {
            System.out.println("Pintar acá es un efecto secundario!");
            return number % 2 == 0;
        };

        int i = 50;
        while ((i--) > 0) {
            System.out.println("Es par? : " + even.test(5));
        }
    }

    public static void main(String args[]) {
        pureEven();
        impureEven();
    }
}
