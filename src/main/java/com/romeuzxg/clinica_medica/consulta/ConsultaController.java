package com.romeuzxg.clinica_medica.consulta;

import com.romeuzxg.clinica_medica.consulta.dto.ConsultaRequest;
import com.romeuzxg.clinica_medica.consulta.dto.ConsultaResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping("/listar")
    public ResponseEntity<Page<ConsultaResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(consultaService.findAll(pageable));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ConsultaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.findById(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ConsultaResponse> save(@RequestBody @Valid ConsultaRequest consultaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.save(consultaRequest));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ConsultaResponse> updateById(@PathVariable Long id, @RequestBody @Valid ConsultaRequest consultaRequest) {
        return ResponseEntity.ok(consultaService.updateById(id, consultaRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        consultaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
