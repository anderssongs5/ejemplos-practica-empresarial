package co.edu.udea.practicaempresarial.java8lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EjemplosSintaxis {

    // Interfaz con un método, que recibe un argumento y retorna un valor
    interface Mapper<V, M> {
        M map(V value);
    }

    // Método que toma una lista de tipo V y con el Mapper la transforma
    // a una lista de tipo M
    public static <V, M> List<M> map(List<V> list, Mapper<V, M> mapper) {
        List<M> mapped = new ArrayList<>(list.size());
        for (V value : list) {
            mapped.add(mapper.map(value));
        }

        return mapped;
    }

    // Intefaz con un método que recibe un parámetro y no retorna ningún valo
    interface Action<V> {
        void act(V value);
    }

    public static <V> void act(List<V> list, Action<V> action) {
        for (V v : list) {
            action.act(v);
        }
    }

    public static void correr() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Calculando la potencia a la dos de cada número de la lista
        // utilizando el método estático map como si fuera antes de Java8.
        List<Integer> mapped1 = map(numbers, new Mapper<Integer, Integer>() {
            @Override
            public Integer map(Integer value) {
                return value * value;
            }
        });
        // Se imprimen los valores de la lista mapped1
        mapped1.stream().forEach(System.out::println);

        // Calculando la potencia a la dos de cada número de la lista
        // utilizando expresiones Lambda.
        List<Integer> mapped2 = map(numbers, v -> v * v);
        // Se imprimen los valores de la lista mapped2
        mapped2.stream().forEach(System.out::println);

        // Se utiliza método estático act y se imprime cada valor de la lista.
        act(numbers, System.out::println);
        // Se utiliza método estático act y se utiliza expresión lambda.
        act(numbers, n -> System.out.println(n));

        // Uso de interfaces funcionales propias de Java

        Consumer<Object> print = System.out::println;
        numbers.stream().forEach(n -> print.accept(n));

        print.andThen(print).accept("Aquí voy!"); // 2x
        
        Function<Integer, String> toString = (value) -> (value + "!");
        print.accept(toString.apply(1000));
        
        Predicate<Integer> odd = (value) -> (value % 2 != 0);
        print.accept(odd.test(1));
        print.accept(odd.test(6));
    }
}
