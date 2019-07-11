package azarenka.exceptions;

/**
 * Response Exception.
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/11/19
 *
 * @author Anton Azarenka
 */
public class ResponseException extends RuntimeException {

    public ResponseException(String message) {
        super(message);
    }

    public ResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseException(Throwable cause) {
        super(cause);
    }
}
