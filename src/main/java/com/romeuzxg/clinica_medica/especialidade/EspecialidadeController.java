package com.romeuzxg.clinica_medica.especialidade;

import com.romeuzxg.clinica_medica.especialidade.dto.request.EspecialidadeRequest;
import com.romeuzxg.clinica_medica.especialidade.dto.response.EspecialidadeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    @GetMapping("/listar/especialidade")
    public ResponseEntity<List<EspecialidadeResponse>> findByEspecialidade(@RequestParam(required = false) String nome, Pageable pageable) {
        if (nome != null && !nome.isBlank()) {
            return ResponseEntity.ok(especialidadeService.findByEspecialidade(nome));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<EspecialidadeResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(especialidadeService.findAll(pageable));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<EspecialidadeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(especialidadeService.findById(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<EspecialidadeResponse> save(@RequestBody EspecialidadeRequest especialidadeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadeService.save(especialidadeRequest));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EspecialidadeResponse> updateById(@PathVariable Long id, @RequestBody EspecialidadeRequest especialidadeRequest) {
        return ResponseEntity.ok(especialidadeService.updateById(id, especialidadeRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        especialidadeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
