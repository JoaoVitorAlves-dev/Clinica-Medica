package com.romeuzxg.clinica_medica.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNome(String username);

    Boolean existsByNome(String nome);

    boolean existsByNomeAndIdNot(String nome, Long id);
}
