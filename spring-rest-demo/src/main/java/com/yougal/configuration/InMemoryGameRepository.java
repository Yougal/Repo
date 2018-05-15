package com.yougal.configuration;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.yougal.domain.Door;
import com.yougal.domain.Door.DoorContent;
import com.yougal.domain.Game;
import com.yougal.domain.GameDoesNotExistException;

@Component
public class InMemoryGameRepository implements GameRepository{

    private static final SecureRandom RANDOM = new SecureRandom();

    private final Map<Long, Game> games = new HashMap<Long, Game>();

    private final AtomicLong idGenerator = new AtomicLong();

    private final Object monitor = new Object();

    public Game create() {
        synchronized (this.monitor) {
            Long id = this.idGenerator.getAndIncrement();
            Game game = new Game(id, createDoors());

            this.games.put(id, game);

            return game;
        }
    }

    public Game retrieve(Long id) throws GameDoesNotExistException {
        synchronized (this.monitor) {
            if (this.games.containsKey(id)) {
                return this.games.get(id);
            }

            throw new GameDoesNotExistException(id);
        }
    }

    public void remove(Long id) throws GameDoesNotExistException {
        synchronized (this.monitor) {
            if (this.games.containsKey(id)) {
                this.games.remove(id);
            } else {
                throw new GameDoesNotExistException(id);
            }
        }

    }

    private Set<Door> createDoors() {
        Set<Door> doors = new HashSet<Door>();

        int winner = RANDOM.nextInt(3);
        for (int i = 0; i < 3; i++) {
            Long id = this.idGenerator.getAndIncrement();
            DoorContent content = i == winner ? DoorContent.JUERGEN : DoorContent.SMALL_FURRY_ANIMAL;
            doors.add(new Door(id, content));
        }

        return doors;
    }

}