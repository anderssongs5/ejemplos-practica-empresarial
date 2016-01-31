package co.edu.udea.practicaempresarial;

import co.edu.udea.practicaempresarial.functions.FuncionesOrdenSuperior;
import co.edu.udea.practicaempresarial.functions.FuncionesPuras;
import co.edu.udea.practicaempresarial.java8lambdas.EjemplosSintaxis;
import co.edu.udea.practicaempresarial.rx.ObservableFrom;
import co.edu.udea.practicaempresarial.rx.ObservableJust;
import co.edu.udea.practicaempresarial.rx.EjemplosObservables;
import co.edu.udea.practicaempresarial.rx.SumaReactivaV1;
import co.edu.udea.practicaempresarial.rx.SumaReactivaV2;
import co.edu.udea.practicaempresarial.rx.general.CreadorObservables;

public class Aplicacion {

    public static void main(String[] args) {
        EjemplosObservables.ejemplo0();

        EjemplosObservables.ejemplo1();

        // SumaReactivaV1.correr();

        EjemplosSintaxis.correr();

        // SumaReactivaV2.correr();

        FuncionesPuras.pureEven();
        FuncionesPuras.impureEven();

        FuncionesOrdenSuperior.probarHighSum();
        FuncionesOrdenSuperior.probarHighSumDiferente();
        FuncionesOrdenSuperior.probarSaludar();

        ObservableFrom.correr();
        ObservableJust.correr();
    }
}
