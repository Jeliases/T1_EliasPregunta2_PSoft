package Service;

public interface IConsultaService {
    boolean tieneDeudasPendientes (String clienteId);
    boolean simulacionAprobada(String codigoPrestamo);
}
