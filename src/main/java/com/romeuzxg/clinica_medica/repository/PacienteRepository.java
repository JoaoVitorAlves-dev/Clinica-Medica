package com.romeuzxg.clinica_medica.repository;

import com.romeuzxg.clinica_medica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
