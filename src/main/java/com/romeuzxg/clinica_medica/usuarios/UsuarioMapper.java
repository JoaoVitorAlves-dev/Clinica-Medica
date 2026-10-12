package com.romeuzxg.clinica_medica.usuarios;

import com.romeuzxg.clinica_medica.usuarios.dto.request.UserRequest;
import com.romeuzxg.clinica_medica.usuarios.dto.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public User toEntity(UserRequest userRequest) {
        User user = new User();
        user.setNome(userRequest.nome());
        user.setSenha(userRequest.senha());
        return user;
    }

    public UserResponse toDTO(User user) {
        return new UserResponse(
                user.getId(), user.getNome(), user.getRole().getNome()
        );
    }

}
