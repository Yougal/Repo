package com.yougal.domain;

public final class DoorDoesNotExistException extends Exception {

    private static final long serialVersionUID = 2092342614756796723L;

    private static final String MESSAGE_FORMAT = "Door '%d' in game '%d' does not exist";

    public DoorDoesNotExistException(Long gameId, Long doorId) {
        super(String.format(MESSAGE_FORMAT, doorId, gameId));
    }
}