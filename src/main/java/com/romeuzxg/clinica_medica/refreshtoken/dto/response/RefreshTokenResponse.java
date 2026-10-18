package com.romeuzxg.clinica_medica.refreshtoken.dto.response;

import jakarta.validation.constraints.NotBlank;

public record RefreshTokenResponse(
        @NotBlank String accessToken,
        @NotBlank String refreshToken
) {
}
