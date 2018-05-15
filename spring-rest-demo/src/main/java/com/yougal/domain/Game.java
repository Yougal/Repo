package com.yougal.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.yougal.domain.Door.DoorContent;
import com.yougal.domain.Door.DoorStatus;

public class Game {
    private final Long id;

    private final Map<Long, Door> doors;

    private final Object monitor = new Object();

    private volatile GameStatus status;
    
    public enum GameStatus {

        AWAITING_INITIAL_SELECTION, //
        AWAITING_FINAL_SELECTION, //
        LOST, //
        WON;
    }

    public Game(Long id, Set<Door> doors) {
        this.id = id;

        this.doors = new HashMap<Long, Door>();
        for (Door door : doors) {
            this.doors.put(door.getId(), door);
        }

        this.status = GameStatus.AWAITING_INITIAL_SELECTION;
    }

    public void select(Long doorId) throws IllegalTransitionException, DoorDoesNotExistException {
        synchronized (this.monitor) {
            if (this.status != GameStatus.AWAITING_INITIAL_SELECTION) {
                throw new IllegalTransitionException(this.id, this.status, GameStatus.AWAITING_FINAL_SELECTION);
            }

            Door door = getDoor(doorId);
            door.setStatus(DoorStatus.SELECTED);

            openHintDoor();

            this.status = GameStatus.AWAITING_FINAL_SELECTION;
        }
    }

    public void open(Long doorId) throws IllegalTransitionException, DoorDoesNotExistException {
        synchronized (this.monitor) {
            if (this.status != GameStatus.AWAITING_FINAL_SELECTION) {
                throw new IllegalTransitionException(this.id, this.status, GameStatus.WON);
            }

            Door door = getDoor(doorId);
            if (DoorStatus.OPEN == door.getStatus()) {
                throw new IllegalTransitionException(this.id, doorId, door.getStatus(), DoorStatus.OPEN);
            }

            door.setStatus(DoorStatus.OPEN);

            if (DoorContent.JUERGEN == door.getContent()) {
                this.status = GameStatus.WON;
            } else {
                this.status = GameStatus.LOST;
            }
        }
    }

    public Long getId() {
        return this.id;
    }

    public Door getDoor(Long doorId) throws DoorDoesNotExistException {
        if (this.doors.containsKey(doorId)) {
            return this.doors.get(doorId);
        }

        throw new DoorDoesNotExistException(this.id, doorId);
    }

    public Set<Door> getDoors() {
        return new HashSet<Door>(this.doors.values());
    }

    public GameStatus getStatus() {
        synchronized (this.monitor) {
            return this.status;
        }
    }

    private void openHintDoor() {
        for (Door door : getDoors()) {
            if (DoorStatus.CLOSED == door.getStatus() && DoorContent.SMALL_FURRY_ANIMAL == door.peekContent()) {
                door.setStatus(DoorStatus.OPEN);
                break;
            }
        }
    }
}
