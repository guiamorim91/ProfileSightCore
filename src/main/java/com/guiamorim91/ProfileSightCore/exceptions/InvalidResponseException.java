package com.guiamorim91.ProfileSightCore.exceptions;

import java.io.Serial;

public class InvalidResponseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidResponseException() {
        super("As respostas fornecidas não correspondem às perguntas exibidas.");
    }
}
