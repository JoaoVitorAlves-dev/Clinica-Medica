package com.romeuzxg.clinica_medica.mapper;

import com.romeuzxg.clinica_medica.dto.request.PacienteRequest;
import com.romeuzxg.clinica_medica.dto.response.PacienteResponse;
import com.romeuzxg.clinica_medica.entity.Paciente;
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
