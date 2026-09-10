package com.romeuzxg.clinica_medica.mapper;

import com.romeuzxg.clinica_medica.dto.request.EspecialidadeRequest;
import com.romeuzxg.clinica_medica.dto.response.EspecialidadeResponse;
import com.romeuzxg.clinica_medica.entity.Especialidade;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EspecialidadeMapper {

    public Especialidade toEntity(EspecialidadeRequest especialidadeRequest) {
        Especialidade especialidade = new Especialidade();
        especialidade.setNome(especialidadeRequest.nome());
        return especialidade;
    }

    public EspecialidadeResponse toDTO(Especialidade especialidade) {
        return new EspecialidadeResponse(especialidade.getId(), especialidade.getNome());
    }

}
