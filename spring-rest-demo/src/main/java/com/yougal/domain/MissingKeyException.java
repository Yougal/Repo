package com.yougal.domain;

public class  MissingKeyException extends Exception {

    private static final long serialVersionUID = 8871262472437289684L;

    private static final String MESSAGE_FORMAT = "Payload is missing key '%s'";

    public MissingKeyException(String key) {
        super(String.format(MESSAGE_FORMAT, key));
    }

}