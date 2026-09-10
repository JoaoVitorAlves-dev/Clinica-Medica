package com.romeuzxg.clinica_medica.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "convenio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Convenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pacienteId")
    private Paciente paciente;

}
