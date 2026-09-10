package com.romeuzxg.clinica_medica.especialidade;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "especialidade")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

}
