package com.romeuzxg.clinica_medica.especialidade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {

    List<Especialidade> findByNomeContainingIgnoreCase(String nome);

}
