package com.romeuzxg.clinica_medica.usuarios;

import com.romeuzxg.clinica_medica.config.TokenService;
import com.romeuzxg.clinica_medica.exceptions.IdNotFoundException;
import com.romeuzxg.clinica_medica.exceptions.UsuarioNotFoundException;
import com.romeuzxg.clinica_medica.refreshtoken.RefreshToken;
import com.romeuzxg.clinica_medica.refreshtoken.RefreshTokenService;
import com.romeuzxg.clinica_medica.refreshtoken.dto.response.RefreshTokenResponse;
import com.romeuzxg.clinica_medica.role.dto.Role;
import com.romeuzxg.clinica_medica.role.dto.RoleRepository;
import com.romeuzxg.clinica_medica.usuarios.dto.request.LoginRequest;
import com.romeuzxg.clinica_medica.usuarios.dto.request.UsuarioRequest;
import com.romeuzxg.clinica_medica.usuarios.dto.response.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final RefreshTokenService refreshTokenService;

    public Page<UsuarioResponse> listar(Pageable pageable) {
        return usuarioRepository.findAll(pageable).map(UsuarioMapper::toDTO);
    }

    public UsuarioResponse findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Usuario não encontrado."));
        return UsuarioMapper.toDTO(usuario);
    }

    public void cadastrar(UsuarioRequest usuarioRequest) {
        if (usuarioRepository.existsByNome(usuarioRequest.nome())) {
            throw new IdNotFoundException("Usuario já esta sendo usado.");
        }

        Role user = roleRepository.findByNome("USER").orElseGet(() -> {
            Role role = new Role();
            role.setNome("USER");
            return roleRepository.save(role);
        });

        Usuario entity = UsuarioMapper.toEntity(usuarioRequest);
        entity.setNome(usuarioRequest.nome());
        entity.setSenha(passwordEncoder.encode(usuarioRequest.senha()));
        entity.setRole(user);

        usuarioRepository.save(entity);
    }

    public RefreshTokenResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.nome(), loginRequest.senha()));

        Usuario usuario = usuarioRepository.findByNome(loginRequest.nome())
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario não encontrado."));

        String access = tokenService.gerarToken(usuario.getNome());
        String refresh = refreshTokenService.validarERotacionar(access).getToken();

        return new RefreshTokenResponse(access, refresh);
    }

    public UsuarioResponse atualizar(Long id, UsuarioRequest usuarioRequest, String usernameAutenticado) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Usuario não existe."));

        if (!usuarioRequest.nome().equals(usernameAutenticado)) {
            throw new IdNotFoundException("Você so pode alterar sua propria conta.");
        }
        if (usuarioRepository.existsByNomeAndIdNot(usuarioRequest.nome(), id)) {
            throw new IdNotFoundException("Username já existe.");
        }

        usuario.setNome(usuarioRequest.nome());
        usuario.setSenha(passwordEncoder.encode(usuarioRequest.senha()));

        return UsuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    public void deletar(Long id) {
        usuarioRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Id não encontrado."));
        usuarioRepository.deleteById(id);
    }

}
