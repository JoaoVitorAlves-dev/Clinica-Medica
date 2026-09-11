package com.romeuzxg.clinica_medica.medico;

import com.romeuzxg.clinica_medica.especialidade.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Especialidade findByEspecialidade(Especialidade especialidade);
}
