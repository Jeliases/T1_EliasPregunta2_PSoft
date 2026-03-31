import Service.IConsultaService;
import Service.PrestamoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PrestamoTest {

    IConsultaService mockConsulta = mock(IConsultaService.class);
    PrestamoService service = new PrestamoService(mockConsulta);

    //**@Test
    //**void testRechazoPorDeudas(){

    //**when(mockConsulta.tieneDeudasPendientes("C100")).thenReturn(true);

    //**String respuesta = service.registrarPrestamo("P001", 700,5000,1000,12, "C100");

    //** assertEquals("Préstamo rechazado por deudas",respuesta);

    //**verify(mockConsulta).tieneDeudasPendientes("C100");}

    @Test
    void testCuotaExcedida(){
        when(mockConsulta.tieneDeudasPendientes("C200")).thenReturn(false);
        when(mockConsulta.simulacionAprobada("P002")).thenReturn(true);

        String respuesta = service.registrarPrestamo("P002", 750, 3000, 1500, 24, "C200");
        System.out.println("Mensaje: " + respuesta);
        assertEquals("Cuota excede el límite permitido", respuesta);

    }
}
