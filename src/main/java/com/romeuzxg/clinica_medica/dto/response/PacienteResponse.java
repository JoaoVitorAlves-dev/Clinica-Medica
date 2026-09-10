package com.romeuzxg.clinica_medica.dto.response;

import java.time.LocalDate;

public record PacienteResponse(Long id, String nome, String cpf, String email, LocalDate dataNascimento) {
}
