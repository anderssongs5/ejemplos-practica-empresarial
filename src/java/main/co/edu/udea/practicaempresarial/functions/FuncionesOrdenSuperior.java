package co.edu.udea.practicaempresarial.functions;

import java.util.function.Function;

public class FuncionesOrdenSuperior {

    private static <T, R> int highSum(Function<T, Integer> f1, Function<R, Integer> f2, T data1, R data2) {
        return f1.apply(data1) + f2.apply(data2);
    }

    private static Function<String, String> saludar(String saludo) {
        return (name) -> (saludo + " " + name + "!");
    }

    private static void probarHighSum() {
        int resultado = highSum(v -> v * v, v -> v + v, 3, 2);
        System.out.println("Resultado probarHighSum: " + resultado);
    }

    private static void probarHighSumDiferente() {
        Function<String, Integer> strToInt = s -> Integer.parseInt(s);

        int resultado = highSum(strToInt, strToInt, "5", "2");
        System.out.println("Resultado probarHighSumDiferente: " + resultado);
    }

    public static void main(String args[]) {
        System.out.println(saludar("Hola").apply("mundo"));

        System.out.println(saludar("Hola").apply("llave"));

        Function<String, String> saludo = saludar("Hola");
        System.out.println(saludo.apply("Tanya"));
        System.out.println(saludo.apply("Dali"));

        probarHighSum();

        probarHighSumDiferente();
    }
}
