package ec.edu.espe.arquitectura.examen2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.examen2.model.Empresa;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresa, String> {
}