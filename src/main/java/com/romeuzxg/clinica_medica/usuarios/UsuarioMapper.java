package com.romeuzxg.clinica_medica.usuarios;

import com.romeuzxg.clinica_medica.usuarios.dto.request.UsuarioRequest;
import com.romeuzxg.clinica_medica.usuarios.dto.response.UsuarioResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.nome());
        usuario.setSenha(usuarioRequest.senha());
        return usuario;
    }

    public UsuarioResponse toDTO(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(), usuario.getNome(), usuario.getRole().getNome()
        );
    }

}
