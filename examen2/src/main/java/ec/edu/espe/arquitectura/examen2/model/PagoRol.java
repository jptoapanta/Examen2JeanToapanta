package ec.edu.espe.arquitectura.examen2.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@Document(collection = "pago_rol")
public class PagoRol {
    @Id
    private String id;
    private Integer mes;
    private Empresa rucEmpresa;
    private String cuentaPrincipal;
    private BigDecimal valorTotal;
    private BigDecimal valorReal;
    private List<EmpleadoPago> empleadosPagos;

}