package ec.edu.espe.arquitectura.examen2.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Builder
public class Empleado {
    @Indexed(unique = true)
    private String ci;
    private String apellidos;
    private String nombres;
    private String numeroCuenta;
}
