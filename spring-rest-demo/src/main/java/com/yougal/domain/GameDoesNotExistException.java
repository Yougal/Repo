package com.yougal.domain;

public final class GameDoesNotExistException extends Exception {

    private static final long serialVersionUID = 7996516744853733268L;

    private static final String MESSAGE_FORMAT = "Game '%d' does not exist";

    public GameDoesNotExistException(Long gameId) {
        super(String.format(MESSAGE_FORMAT, gameId));
    }
}
