package com.romeuzxg.clinica_medica.especialidade;

import com.romeuzxg.clinica_medica.especialidade.dto.EspecialidadeRequest;
import com.romeuzxg.clinica_medica.especialidade.dto.EspecialidadeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    @GetMapping
    public ResponseEntity<List<EspecialidadeResponse>> findAll(@RequestParam(required = false) String nome) {
        if (nome != null && !nome.isBlank()) {
            return ResponseEntity.ok(especialidadeService.findByEspecialidade(nome));
        }
        return ResponseEntity.ok(especialidadeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(especialidadeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EspecialidadeResponse> save(@RequestBody EspecialidadeRequest especialidadeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadeService.save(especialidadeRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeResponse> updateById(@PathVariable Long id, @RequestBody EspecialidadeRequest especialidadeRequest) {
        return ResponseEntity.ok(especialidadeService.updateById(id, especialidadeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        especialidadeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
