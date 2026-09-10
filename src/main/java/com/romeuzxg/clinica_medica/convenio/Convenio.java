package com.romeuzxg.clinica_medica.convenio;

import com.romeuzxg.clinica_medica.paciente.Paciente;
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
