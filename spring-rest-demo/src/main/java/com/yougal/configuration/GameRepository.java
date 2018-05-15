package com.yougal.configuration;

import com.yougal.domain.Game;
import com.yougal.domain.GameDoesNotExistException;

public interface GameRepository {
	Game create();

	Game retrieve(Long id) throws GameDoesNotExistException;

	void remove(Long id) throws GameDoesNotExistException;
}
