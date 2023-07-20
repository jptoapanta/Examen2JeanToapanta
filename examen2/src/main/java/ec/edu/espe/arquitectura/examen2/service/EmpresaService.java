package ec.edu.espe.arquitectura.examen2.service;

import ec.edu.espe.arquitectura.examen2.dto.EmpleadoRQ;
import ec.edu.espe.arquitectura.examen2.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen2.dto.EmpleadoRS;
import ec.edu.espe.arquitectura.examen2.dto.EmpresaRS;
import ec.edu.espe.arquitectura.examen2.model.Empleado;
import ec.edu.espe.arquitectura.examen2.model.Empresa;
import ec.edu.espe.arquitectura.examen2.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaRS crearEmpresaConEmpleados(EmpresaRQ empresaRQ) {
        Empresa empresa=this.empresaRepository.save(this.EmpresaRQAEmpresa(empresaRQ));
        EmpresaRS empresaRS=this.EmpresaAEmpresaResDto(empresa);
        return empresaRS;
    }

    public Empresa EmpresaRQAEmpresa(EmpresaRQ empresaRQ) {
        List<Empleado> empleadosList = new ArrayList<>();
        for (EmpleadoRQ empleadoRQ : empresaRQ.getEmpleados()) {
            Empleado empleado = Empleado.builder()
                    .ci(empleadoRQ.getCi())
                    .nombres(empleadoRQ.getNombres())
                    .apellidos(empleadoRQ.getApellidos())
                    .numeroCuenta(empleadoRQ.getNumeroCuenta())
                    .build();
            empleadosList.add(empleado);
        }

        Empresa empresa = Empresa.builder().ruc(empresaRQ.getRuc()).razonSocial(empresaRQ.getRazonSocial()).cuentaPrincipal(empresaRQ.getCuentaPrincipal()).empleados(empleadosList).build();
        return empresa;
    }
    public EmpresaRS EmpresaAEmpresaResDto(Empresa empresa){
        List<EmpleadoRS> empleadoRSList = new ArrayList<>();
        for (Empleado empleados : empresa.getEmpleados()) {
            EmpleadoRS empleadoRS = EmpleadoRS.builder()
                    .ci(empleados.getCi())
                    .nombres(empleados.getNombres())
                    .apellidos(empleados.getApellidos())
                    .numeroCuenta(empleados.getNumeroCuenta())
                    .build();
            empleadoRSList.add(empleadoRS);
        }
        EmpresaRS empresaRS = EmpresaRS.builder().ruc(empresa.getRuc()).razonSocial(empresa.getRazonSocial()).cuentaPrincipal(empresa.getCuentaPrincipal()).empleados(empleadoRSList).build();
        return empresaRS;
    }

}