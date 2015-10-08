package com.epam.exeptions;

public class KlondikeException extends Exception {

    private static final long serialVersionUID = 5321006047491127711L;

    public KlondikeException(String message, Throwable cause) {
        super(message, cause);
    }

    public KlondikeException(String message) {
        super(message);
    }

    public KlondikeException(Throwable cause) {
        super(cause);
    }

}
