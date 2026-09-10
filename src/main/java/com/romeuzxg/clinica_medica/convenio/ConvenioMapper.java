package com.romeuzxg.clinica_medica.convenio;

import com.romeuzxg.clinica_medica.convenio.dto.ConvenioRequest;
import com.romeuzxg.clinica_medica.convenio.dto.ConvenioResponse;
import com.romeuzxg.clinica_medica.paciente.Paciente;
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
