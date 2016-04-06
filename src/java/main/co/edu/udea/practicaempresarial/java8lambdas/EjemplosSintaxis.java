package co.edu.udea.practicaempresarial.java8lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemplosSintaxis {

    // Interfaz con un m�todo, que recibe un argumento y retorna un valor
    interface Mapper<V, M> {
        M map(V value);
    }

    // M�todo que toma una lista de tipo V y con el Mapper la transforma
    // a una lista de tipo M
    public static <V, M> List<M> map(List<V> list, Mapper<V, M> mapper) {
        List<M> mapped = new ArrayList<>(list.size());
        for (V value : list) {
            mapped.add(mapper.map(value));
        }

        return mapped;
    }

    // Intefaz con un m�todo que recibe un par�metro y no retorna ning�n valor
    interface Action<V> {
        void act(V value);
    }

    public static <V> void act(List<V> list, Action<V> action) {
        for (V v : list) {
            action.act(v);
        }
    }

    public static void main(String args[]) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Calculando la potencia a la dos de cada n�mero de la lista
        // utilizando el m�todo est�tico map como si fuera antes de Java8.
        List<Integer> mapped1 = map(numbers, new Mapper<Integer, Integer>() {
            @Override
            public Integer map(Integer value) {
                return value * value;
            }
        });
        // Se imprimen los valores de la lista mapped1
        mapped1.stream().forEach(System.out::println);

        // Calculando la potencia a la dos de cada n�mero de la lista
        // utilizando expresiones Lambda.
        List<Integer> mapped2 = map(numbers, v -> v * v);
        // Se imprimen los valores de la lista mapped2
        mapped2.stream().forEach(System.out::println);

        // Se utiliza m�todo est�tico act y se imprime cada valor de la lista.
        act(numbers, System.out::println);
        // Se utiliza m�todo est�tico act y se utiliza expresi�n lambda.
        act(numbers, n -> System.out.println(n));
    }
}
