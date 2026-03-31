package Service;

public class PrestamoService {
    private IConsultaService consultaService;

    public PrestamoService(IConsultaService consultaService){
        this.consultaService = consultaService;
    }

    public String registrarPrestamo(String codigo, int score, double ingreso, double cuota, int plazo, String clienteId){
        if (score < 600) return "Score insuficiente";

        if(consultaService.tieneDeudasPendientes(clienteId)){
            return "Préstamo rechazado por deudas";
        }

        if (!consultaService.simulacionAprobada(codigo)){
            return "Simulación previa obligatoria no realizada";
        }

        if (cuota > (ingreso * 0.30)){

            return "Cuota excede el límite permitido";
        }


            return "Préstamo registrado exitosamente";
    }
}

