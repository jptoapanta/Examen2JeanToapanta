package ec.edu.espe.arquitectura.examen2.controller;

import ec.edu.espe.arquitectura.examen2.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen2.dto.EmpresaRS;
import ec.edu.espe.arquitectura.examen2.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;
    public ResponseEntity<EmpresaRS> crearEmpresa(@RequestBody EmpresaRQ empresaRQ) {
        return ResponseEntity.ok(this.empresaService.crearEmpresaConEmpleados(empresaRQ));
    }
}