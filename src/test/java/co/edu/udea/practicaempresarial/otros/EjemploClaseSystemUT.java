package co.edu.udea.practicaempresarial.otros;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import co.edu.udea.practicaempresarial.otros.EjemploClaseSystem;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ System.class, EjemploClaseSystem.class })
public class EjemploClaseSystemUT {

    @InjectMocks
    private EjemploClaseSystem sut;

    private final String respuesta = "temp";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        PowerMock.mockStatic(System.class);
    }

    @Test
    public final void obtenerDirectorioTemporalTest() {
        EasyMock.expect(System.getProperty("java.io.tmpdir")).andReturn(respuesta);

        PowerMock.replayAll();
        assertEquals(respuesta, sut.obtenerDirectorioTemporal());
        PowerMock.verifyAll();
    }
}
