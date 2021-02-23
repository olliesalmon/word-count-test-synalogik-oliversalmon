package com.synalogik.dao;

public class NonExistentTextFileException extends Exception {
    NonExistentTextFileException(String message) {
        super(message);
    }

    NonExistentTextFileException(String message, Throwable cause) {
        super(message, cause);
    }
}