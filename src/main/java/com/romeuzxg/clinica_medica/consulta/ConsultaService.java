package com.romeuzxg.clinica_medica.consulta;

import com.romeuzxg.clinica_medica.consulta.dto.ConsultaRequest;
import com.romeuzxg.clinica_medica.consulta.dto.ConsultaResponse;
import com.romeuzxg.clinica_medica.especialidade.Especialidade;
import com.romeuzxg.clinica_medica.especialidade.EspecialidadeMapper;
import com.romeuzxg.clinica_medica.especialidade.EspecialidadeRepository;
import com.romeuzxg.clinica_medica.especialidade.dto.EspecialidadeRequest;
import com.romeuzxg.clinica_medica.especialidade.dto.EspecialidadeResponse;
import com.romeuzxg.clinica_medica.medico.Medico;
import com.romeuzxg.clinica_medica.paciente.Paciente;
import com.romeuzxg.clinica_medica.exceptions.IdNotFoundException;
import com.romeuzxg.clinica_medica.medico.MedicoRepository;
import com.romeuzxg.clinica_medica.paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public List<ConsultaResponse> findAll() {
        return consultaRepository.findAll().stream()
                .map(ConsultaMapper::toDTO)
                .toList();
    }

    public ConsultaResponse findById(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        return ConsultaMapper.toDTO(consulta);
    }

    public ConsultaResponse save(ConsultaRequest consultaRequest) {
        Paciente paciente = pacienteRepository.findById(consultaRequest.pacienteId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Medico medico = medicoRepository.findById(consultaRequest.medicoId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Consulta save = consultaRepository.save(ConsultaMapper.toEntity(consultaRequest, paciente, medico));
        return ConsultaMapper.toDTO(save);
    }

    public ConsultaResponse updateById(Long id, ConsultaRequest consultaRequest) {
        consultaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Paciente paciente = pacienteRepository.findById(consultaRequest.pacienteId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Medico medico = medicoRepository.findById(consultaRequest.medicoId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Consulta entity = ConsultaMapper.toEntity(consultaRequest, paciente, medico);
        entity.setId(id);
        Consulta save = consultaRepository.save(entity);
        return ConsultaMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }

}
