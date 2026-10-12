package com.romeuzxg.clinica_medica.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Boolean existsByNome(String nome);

    boolean existsByNomeAndIdNot(String nome, Long id);
}
