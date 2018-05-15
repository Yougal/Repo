package com.yougal.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import com.yougal.controller.GameController;
import com.yougal.domain.Door;
import com.yougal.domain.Game;


@Component
public class DoorsResourceAssembler extends ResourceSupport {

	 private final DoorResourceAssembler doorResourceAssembler;

	    @Autowired
	    public DoorsResourceAssembler(DoorResourceAssembler doorResourceAssembler) {
	        this.doorResourceAssembler = doorResourceAssembler;
	    }

	    public DoorsResource toResource(Game game) {
	        DoorsResource resource = new DoorsResource();

	        for (Door door : game.getDoors()) {
	            resource.doors.add(this.doorResourceAssembler.toResource(game, door));
	        }
	        resource.add(linkTo(GameController.class).slash(game.getId()).slash("doors").withSelfRel());

	        return resource;
	    }
}