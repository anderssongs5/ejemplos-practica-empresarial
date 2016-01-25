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
