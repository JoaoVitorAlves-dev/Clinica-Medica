package com.romeuzxg.clinica_medica.consulta;

import com.romeuzxg.clinica_medica.consulta.dto.request.ConsultaRequest;
import com.romeuzxg.clinica_medica.consulta.dto.response.ConsultaResponse;
import com.romeuzxg.clinica_medica.medico.Medico;
import com.romeuzxg.clinica_medica.paciente.Paciente;
import com.romeuzxg.clinica_medica.exceptions.IdNotFoundException;
import com.romeuzxg.clinica_medica.medico.MedicoRepository;
import com.romeuzxg.clinica_medica.paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public Page<ConsultaResponse> findAll(Pageable pageable) {
        return consultaRepository.findAll(pageable).map(ConsultaMapper::toDTO);
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
