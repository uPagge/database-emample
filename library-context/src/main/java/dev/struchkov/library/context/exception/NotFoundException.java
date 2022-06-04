package dev.struchkov.library.context.exception;

import java.text.MessageFormat;
import java.util.function.Supplier;

public class NotFoundException extends LibraryException {

    protected NotFoundException(String message) {
        super(message);
    }

    protected NotFoundException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

    public static Supplier<NotFoundException> notFoundException(String message) {
        return () -> new NotFoundException(message);
    }

    public static Supplier<NotFoundException> notFoundException(String message, Object... args) {
        return () -> new NotFoundException(message, args);
    }

}
