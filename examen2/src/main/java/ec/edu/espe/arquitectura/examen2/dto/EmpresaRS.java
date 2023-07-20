package ec.edu.espe.arquitectura.examen2.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmpresaRS {
    private String ruc;
    private String razonSocial;
    private String cuentaPrincipal;
    private List<EmpleadoRS> empleados;
}