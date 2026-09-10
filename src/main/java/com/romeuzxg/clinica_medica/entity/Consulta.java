package com.romeuzxg.clinica_medica.entity;

import com.romeuzxg.clinica_medica.enums.StatusConsulta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pacienteId")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medicoId")
    private Medico medico;

    @NotBlank
    @Column(name = "data_hora_consulta", nullable = false)
    private LocalDateTime dataHora;

    @NotBlank
    @Column(name = "status_consulta", nullable = false)
    private StatusConsulta status;

}
