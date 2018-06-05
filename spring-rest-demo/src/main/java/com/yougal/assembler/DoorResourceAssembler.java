package com.yougal.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.stereotype.Component;

import com.yougal.controller.GameController;
import com.yougal.domain.Door;
import com.yougal.domain.Game;

@Component
public class DoorResourceAssembler{

	public DoorResource toResource(Game game, Door door) {
		DoorResource resource = new DoorResource();
		resource.status = door.getStatus();
		resource.content = door.getContent();
		resource.add(linkTo(GameController.class).slash(game.getId()).slash("doors").slash(door.getId()).withSelfRel());

		return resource;
	}

}
