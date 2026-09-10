package com.romeuzxg.clinica_medica.paciente.dto;

import java.time.LocalDate;

public record PacienteResponse(Long id, String nome, String cpf, String email, LocalDate dataNascimento) {
}
