package com.romeuzxg.clinica_medica.role.dto;

import com.romeuzxg.clinica_medica.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tb_roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<Usuario> usuarios;

}
