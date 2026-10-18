package com.romeuzxg.clinica_medica.role.dto;

import com.romeuzxg.clinica_medica.role.dto.request.RoleRequest;
import com.romeuzxg.clinica_medica.role.dto.response.RoleResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RoleMapper {

    public Role toEntity(RoleRequest roleRequest) {
        Role role = new Role();
        role.setNome(roleRequest.nome());
        return role;
    }

    public RoleResponse toDTO(Role role) {
        return new RoleResponse(
                role.getId(), role.getNome()
        );
    }

}
