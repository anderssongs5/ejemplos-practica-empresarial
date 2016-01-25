package co.edu.udea.practicaempresarial.functions;

import java.util.function.Predicate;

public class FuncionesPuras {

    public static void pureEven() {
        Predicate<Integer> even = value -> (value % 2 == 0);
        int i = 50;
        while ((i--) > 0) {
            System.out.println("Es par? : " + even.test(5));
        }
    }

    /* Una función pura es aquella que no tiene efectos secundarios y su
     * valor de retorno está solo determinado por su entrada.
     * 
     * Un efecto secundario es cualquier posible salida observable que una
     * función puede producir, por ejemplo, provocar eventos o lanzar 
     * excepciones y I/O, diferente de su valor de retorno. Un efecto
     * secundario también cambia estados compartidos o argumentos mutables.
     * */
    public static void impureEven() {
        Predicate<Integer> even = (number) -> {
            System.out.println("Pintar acá es un efecto secundario!");
            return number % 2 == 0;
        };

        int i = 50;
        while ((i--) > 0) {
            System.out.println("Es par? : " + even.test(5));
        }
    }
}
