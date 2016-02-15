package co.edu.udea.practicaempresarial.rx.reactiveoperators;

import java.util.Arrays;
import java.util.List;

import co.edu.udea.practicaempresarial.rx.general.Helper;
import rx.Observable;

public class Grouping {

    private static List<String> albums = Arrays.asList("The Piper at the Gates of Dawn", "A Saucerful of Secrets",
            "More", "Ummagumma", "Atom Heart Mother", "Meddle", "Obscured by Clouds", "The Dark Side of the Moon",
            "Wish You Were Here", "Animals", "The Wall");

    private static void grouping1() {
        System.out.println("Grouping 1");
        Observable.from(albums).groupBy(a -> a.split(" ").length)
                .subscribe(o -> Helper.suscribirseImprimir(o, o.getKey() + " palabra(s)"));
    }

    private static void grouping2() {
        System.out.println("Grouping 2");
        Observable.from(albums).groupBy(a -> a.replaceAll("[^mM]", "").length(), a -> a.replaceAll("[mM]", "*"))
                .subscribe(o -> Helper.suscribirseImprimir(o, o.getKey() + " apariciones de 'm'"));
    }

    public static void main(String args[]) {
        grouping1();

        grouping2();

        System.out.println("\nPruebas:");
        System.out.println(albums.get(2).replaceAll("[^mM]", ""));
        System.out.println(albums.get(2).replaceAll("[mM]", "*"));
    }
}
