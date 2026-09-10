package com.romeuzxg.clinica_medica.dto.request;

import java.time.LocalDate;

public record PacienteRequest(String nome, String cpf, String email, LocalDate dataNascimento) {
}
