package com.romeuzxg.clinica_medica.especialidade;

import com.romeuzxg.clinica_medica.especialidade.dto.EspecialidadeRequest;
import com.romeuzxg.clinica_medica.especialidade.dto.EspecialidadeResponse;
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
