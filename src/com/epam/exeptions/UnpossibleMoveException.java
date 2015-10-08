package com.epam.exeptions;

public class UnpossibleMoveException extends KlondikeException {

    private static final long serialVersionUID = 5321006047491127711L;

    public UnpossibleMoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnpossibleMoveException(String message) {
        super(message);
    }

    public UnpossibleMoveException(Throwable cause) {
        super(cause);
    }

}
