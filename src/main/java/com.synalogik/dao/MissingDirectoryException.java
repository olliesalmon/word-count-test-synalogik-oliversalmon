package com.synalogik.dao;

public class MissingDirectoryException extends Exception {
    MissingDirectoryException(String message) {
        super(message);
    }

    MissingDirectoryException(String message, Throwable cause) {
        super(message, cause);
    }
}