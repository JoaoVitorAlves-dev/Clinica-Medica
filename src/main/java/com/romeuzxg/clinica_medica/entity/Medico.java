package com.romeuzxg.clinica_medica.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String crm;

    @ManyToOne
    private Especialidade especialidade;
}
