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
     * Una funci�n pura es aquella que no tiene efectos secundarios y su valor
     * de retorno est� solo determinado por su entrada.
     * 
     * Un efecto secundario es cualquier posible salida observable que una
     * funci�n puede producir, por ejemplo, provocar eventos o lanzar
     * excepciones y I/O, diferente de su valor de retorno. Un efecto secundario
     * tambi�n cambia estados compartidos o argumentos mutables.
     * 
     * La siguiente funci�n es no pura porque imprime un mensaje cada vez que es
     * llamada. As�, �sta hace dos cosas: prueba si el n�mero es par, e imprime
     * un mensaje como un efecto secundario.
     */
    private static void impureEven() {
        Predicate<Integer> even = (number) -> {
            System.out.println("Pintar ac� es un efecto secundario!");
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
