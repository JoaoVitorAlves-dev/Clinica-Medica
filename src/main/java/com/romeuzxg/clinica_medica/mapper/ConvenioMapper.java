package com.romeuzxg.clinica_medica.mapper;

import com.romeuzxg.clinica_medica.dto.request.ConvenioRequest;
import com.romeuzxg.clinica_medica.dto.response.ConvenioResponse;
import com.romeuzxg.clinica_medica.entity.Convenio;
import com.romeuzxg.clinica_medica.entity.Paciente;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConvenioMapper {

    public Convenio toEntity(ConvenioRequest convenioRequest, Paciente paciente) {
        Convenio convenio = new Convenio();
        convenio.setNome(convenioRequest.nome());
        convenio.setPaciente(paciente);
        return convenio;
    }

    public ConvenioResponse toDTO(Convenio convenio) {
        return new ConvenioResponse(convenio.getId(), convenio.getNome(), convenio.getPaciente().getId());
    }
}
