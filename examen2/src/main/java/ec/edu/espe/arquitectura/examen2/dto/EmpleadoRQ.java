package ec.edu.espe.arquitectura.examen2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoRQ {

    private String ci;
    private String apellidos;
    private String nombres;
    private String numeroCuenta;
}