package com.ceub.poo3.exception;

public class ListarAnimalException extends RuntimeException {

    public ListarAnimalException(String message) {
        super(message);
    }

    public ListarAnimalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListarAnimalException() {
        super("Animal não encontrado");
    }
}
