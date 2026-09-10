package com.romeuzxg.clinica_medica.convenio;

import com.romeuzxg.clinica_medica.convenio.dto.ConvenioRequest;
import com.romeuzxg.clinica_medica.convenio.dto.ConvenioResponse;
import com.romeuzxg.clinica_medica.paciente.Paciente;
import com.romeuzxg.clinica_medica.exceptions.IdNotFoundException;
import com.romeuzxg.clinica_medica.paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConvenioService {

    private final ConvenioRepository convenioRepository;
    private final PacienteRepository pacienteRepository;

    public List<ConvenioResponse> findAll() {
        return convenioRepository.findAll().stream()
                .map(ConvenioMapper::toDTO)
                .toList();
    }

    public ConvenioResponse findById(Long id) {
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        return ConvenioMapper.toDTO(convenio);
    }

    public ConvenioResponse save(ConvenioRequest convenioRequest) {
        Paciente paciente = pacienteRepository.findById(convenioRequest.pacienteId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Convenio save = convenioRepository.save(ConvenioMapper.toEntity(convenioRequest, paciente));
        return ConvenioMapper.toDTO(save);
    }

    public ConvenioResponse updateById(Long id, ConvenioRequest convenioRequest) {
        convenioRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Paciente paciente = pacienteRepository.findById(convenioRequest.pacienteId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Convenio entity = ConvenioMapper.toEntity(convenioRequest, paciente);
        entity.setId(id);
        Convenio save = convenioRepository.save(entity);
        return ConvenioMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        convenioRepository.deleteById(id);
    }

}
