package com.miqueias.r.usuario_servico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmailAlreadyInUseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public EmailAlreadyInUseException(String message) {
        super(message);
    }

}
