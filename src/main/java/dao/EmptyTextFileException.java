package dao;

public class EmptyTextFileException extends Exception {
    EmptyTextFileException(String message) {
        super(message);
    }

    EmptyTextFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
