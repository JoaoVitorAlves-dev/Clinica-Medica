package com.romeuzxg.clinica_medica.paciente.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PacienteRequest(@NotBlank String nome, @NotBlank @Size(min = 11, max = 11) String cpf, @NotBlank @Email String email, @NotNull LocalDate dataNascimento) {
}
