package com.yougal.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.yougal.controller.GameController;
import com.yougal.domain.Game;

@Component
public class GameResourceAssembler implements ResourceAssembler<Game, GameResource>{

	@Override
	public GameResource toResource(Game game) {
		
		GameResource  gameResource = new GameResource();
		gameResource.status=game.getStatus();
		gameResource.add(linkTo(GameController.class).slash(game.getId()).slash("doors").withRel("doors"));
		gameResource.add(linkTo(GameController.class).slash(game.getId()).withSelfRel());
		return gameResource;
	}

}
