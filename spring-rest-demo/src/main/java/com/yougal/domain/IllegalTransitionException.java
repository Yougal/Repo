package com.yougal.domain;

import com.yougal.domain.Door.DoorStatus;
import com.yougal.domain.Game.GameStatus;

public final class IllegalTransitionException extends Exception {

    private static final long serialVersionUID = -8560018436016981574L;

    private static final String DOOR_TRANSITION_FROM_TO_MESSAGE_FORMAT = "It is illegal to transition door '%d' in game '%d' from '%s' to '%s'";

    private static final String DOOR_TRANSITION_TO_MESSAGE_FORMAT = "It is illegal to transition door '%d' in game '%d' to '%s'";

    private static final String GAME_TRANSITION_MESSAGE_FORMAT = "It is illegal to transition game '%d' from '%s' to '%s'";

    public IllegalTransitionException(Long gameId, Long doorId, DoorStatus from, DoorStatus to) {
        super(String.format(DOOR_TRANSITION_FROM_TO_MESSAGE_FORMAT, doorId, gameId, from, to));
    }

    public IllegalTransitionException(Long gameId, Long doorId, DoorStatus to) {
        super(String.format(DOOR_TRANSITION_TO_MESSAGE_FORMAT, doorId, gameId, to));
    }

    public IllegalTransitionException(Long gameId, GameStatus from, GameStatus to) {
        super(String.format(GAME_TRANSITION_MESSAGE_FORMAT, gameId, from, to));
    }
}
