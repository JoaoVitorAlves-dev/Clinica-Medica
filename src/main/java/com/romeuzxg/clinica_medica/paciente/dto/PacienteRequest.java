package com.romeuzxg.clinica_medica.paciente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PacienteRequest(@NotNull String nome, @NotNull String cpf, @Email String email, @NotBlank LocalDate dataNascimento) {
}
