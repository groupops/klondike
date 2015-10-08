package com.epam.exeptions;

public class EndOfGameException extends KlondikeException {

    private static final long serialVersionUID = 5321006047491127711L;

    public EndOfGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public EndOfGameException(String message) {
        super(message);
    }

    public EndOfGameException(Throwable cause) {
        super(cause);
    }

}
