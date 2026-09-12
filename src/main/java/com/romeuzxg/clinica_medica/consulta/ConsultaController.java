package com.romeuzxg.clinica_medica.consulta;

import com.romeuzxg.clinica_medica.consulta.dto.ConsultaRequest;
import com.romeuzxg.clinica_medica.consulta.dto.ConsultaResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> findAll() {
        return ResponseEntity.ok(consultaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ConsultaResponse> save(@RequestBody @Valid ConsultaRequest consultaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.save(consultaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> updateById(@PathVariable Long id, @RequestBody @Valid ConsultaRequest consultaRequest) {
        return ResponseEntity.ok(consultaService.updateById(id, consultaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        consultaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
