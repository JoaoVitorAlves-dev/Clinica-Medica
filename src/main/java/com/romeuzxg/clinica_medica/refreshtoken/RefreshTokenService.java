package com.romeuzxg.clinica_medica.refreshtoken;

import com.romeuzxg.clinica_medica.exceptions.TokenNotFoundException;
import com.romeuzxg.clinica_medica.usuarios.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Value("${api.clinica.medica.expiration.in.days}")
    private Integer expiraEmDias;

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Transactional
    public RefreshToken criar(Usuario usuario) {
        refreshTokenRepository.deleteByUsuario(usuario);

        RefreshToken rt = new RefreshToken();
        rt.setToken(UUID.randomUUID().toString());
        rt.setUsuario(usuario);
        rt.setExpiraEm(Instant.now().plus(expiraEmDias, ChronoUnit.DAYS));
        return refreshTokenRepository.save(rt);
    }

    @Transactional
    public RefreshToken validarERotacionar(String token) {
        RefreshToken atual = refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new TokenNotFoundException("Token não encontrado."));

        if (atual.getExpiraEm().isBefore(Instant.now())) {
            refreshTokenRepository.delete(atual);
            throw new TokenNotFoundException("Token expirado.");
        }

        return criar(atual.getUsuario());
    }

    @Transactional
    public void apagarPorToken(String token) {
        refreshTokenRepository.findByToken(token).ifPresent(refreshTokenRepository::delete);
    }
}
