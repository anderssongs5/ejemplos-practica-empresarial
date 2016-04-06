package co.edu.udea.practicaempresarial.java8lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EjemploInterfacesFuncionales {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

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
