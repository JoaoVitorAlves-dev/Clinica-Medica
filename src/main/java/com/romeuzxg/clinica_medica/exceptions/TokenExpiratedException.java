package com.romeuzxg.clinica_medica.exceptions;

public class TokenExpiratedException extends RuntimeException {

    public TokenExpiratedException(String message) {
        super(message);
    }

}
