package com.romeuzxg.clinica_medica.paciente;

import com.romeuzxg.clinica_medica.paciente.dto.request.PacienteRequest;
import com.romeuzxg.clinica_medica.paciente.dto.response.PacienteResponse;
import com.romeuzxg.clinica_medica.exceptions.IdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public Page<PacienteResponse> findAll(Pageable pageable) {
        return pacienteRepository.findAll(pageable).map(PacienteMapper::toDTO);
    }

    public PacienteResponse findById(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        return PacienteMapper.toDTO(paciente);
    }

    public PacienteResponse save(PacienteRequest pacienteRequest) {
        Paciente entity = PacienteMapper.toEntity(pacienteRequest);
        Paciente save = pacienteRepository.save(entity);
        return PacienteMapper.toDTO(save);
    }

    public PacienteResponse updateById(Long id, PacienteRequest pacienteRequest) {
        pacienteRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Paciente entity = PacienteMapper.toEntity(pacienteRequest);
        entity.setId(id);
        Paciente save = pacienteRepository.save(entity);
        return PacienteMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }

}
