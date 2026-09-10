package com.romeuzxg.clinica_medica.paciente;

import com.romeuzxg.clinica_medica.paciente.dto.PacienteRequest;
import com.romeuzxg.clinica_medica.paciente.dto.PacienteResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PacienteMapper {

    public Paciente toEntity(PacienteRequest pacienteRequest) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteRequest.nome());
        paciente.setCpf(pacienteRequest.cpf());
        paciente.setEmail(pacienteRequest.email());
        paciente.setDataNascimento(pacienteRequest.dataNascimento());
        return paciente;
    }

    public PacienteResponse toDTO(Paciente paciente) {
        return new PacienteResponse(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getDataNascimento());
    }

}
