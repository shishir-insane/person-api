package com.sk.wagawin.person.exception;

public class PersonApiException extends RuntimeException {

    private static final long serialVersionUID = -9197735833475634675L;

    /**
     * Instantiates a new person api exception.
     *
     * @param message
     *            the message
     */
    public PersonApiException(final String message) {
        super(message);
    }

}
