package co.edu.udea.practicaempresarial;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import co.edu.udea.practicaempresarial.DatosIniciales;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DatosIniciales.class)
public class UsoDatosInicialesUT {

    private co.edu.udea.practicaempresarial.UsoDatosIniciales sut;

    @Before
    public void init() {
        sut = new co.edu.udea.practicaempresarial.UsoDatosIniciales();
    }

    @Test
    public final void probarSingletonTest() {
        PowerMockito.mockStatic(DatosIniciales.class);

        DatosIniciales datosInicialesSingleton = PowerMockito.mock(DatosIniciales.class);
        Mockito.when(DatosIniciales.getInstance()).thenReturn(datosInicialesSingleton);
        Mockito.when(datosInicialesSingleton.getDniIngresa()).thenReturn("C1037622083");

        assertEquals("C1037622083", sut.getDniIngresa());
    }
}
