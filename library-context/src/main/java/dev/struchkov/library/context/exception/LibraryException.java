package dev.struchkov.library.context.exception;

public abstract class LibraryException extends RuntimeException {

    protected LibraryException(String message) {
        super(message);
    }

    protected LibraryException(String message, Throwable cause) {
        super(message, cause);
    }

}
