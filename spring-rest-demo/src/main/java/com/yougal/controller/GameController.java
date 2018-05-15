package com.yougal.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yougal.assembler.DoorsResource;
import com.yougal.assembler.DoorsResourceAssembler;
import com.yougal.assembler.GameResource;
import com.yougal.assembler.GameResourceAssembler;
import com.yougal.configuration.GameRepository;
import com.yougal.domain.Door.DoorStatus;
import com.yougal.domain.DoorDoesNotExistException;
import com.yougal.domain.Game;
import com.yougal.domain.GameDoesNotExistException;
import com.yougal.domain.IllegalTransitionException;
import com.yougal.domain.MissingKeyException;

@RequestMapping("/games")
@RestController
public class GameController {
	
	 private static final String STATUS_KEY = "status";
	
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameResourceAssembler gameResourceAssembler;
	
	@Autowired
    private DoorsResourceAssembler doorsResourceAssembler;
	
	@RequestMapping(method=RequestMethod.POST, value= {"/",""})
	public ResponseEntity<Void> createGame() {
		Game game = gameRepository.create();
		HttpHeaders headers= new HttpHeaders();
		headers.setLocation(linkTo(GameController.class).slash(game.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value= {"/{gameId}"})
	public ResponseEntity<GameResource> showGame(@PathVariable Long gameId) throws GameDoesNotExistException{
		Game game = gameRepository.retrieve(gameId);
		GameResource resource = gameResourceAssembler.toResource(game);
		return new ResponseEntity<GameResource>(resource, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{gameId}")
    ResponseEntity<Void> destroyGame(@PathVariable Long gameId) throws GameDoesNotExistException {
        this.gameRepository.remove(gameId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/{gameId}/doors")
    ResponseEntity<DoorsResource> showDoors(@PathVariable Long gameId) throws GameDoesNotExistException {
        Game game = this.gameRepository.retrieve(gameId);
        DoorsResource resource = this.doorsResourceAssembler.toResource(game);

        return new ResponseEntity<DoorsResource>(resource, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/{gameId}/doors/{doorId}")
	    ResponseEntity<Void> modifyDoor(@PathVariable Long gameId, @PathVariable Long doorId, @RequestBody Map<String, String> body)
	        throws MissingKeyException, GameDoesNotExistException, IllegalTransitionException, DoorDoesNotExistException {
	        DoorStatus status = getStatus(body);
	        Game game = this.gameRepository.retrieve(gameId);

	        if (DoorStatus.SELECTED == status) {
	            game.select(doorId);
	        } else if (DoorStatus.OPEN == status) {
	            game.open(doorId);
	        } else {
	            throw new IllegalTransitionException(gameId, doorId, status);
	        }

	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	
	  private DoorStatus getStatus(Map<String, String> body) throws MissingKeyException {
	        if (body.containsKey(STATUS_KEY)) {
	            String value = body.get(STATUS_KEY);

	            try {
	                return DoorStatus.valueOf(value.toUpperCase());
	            } catch (IllegalArgumentException e) {
	                throw new IllegalArgumentException(String.format("'%s' is an illegal value for key '%s'", value, STATUS_KEY), e);
	            }
	        }

	        throw new MissingKeyException(STATUS_KEY);
	    }
	
	@ExceptionHandler({GameDoesNotExistException.class,DoorDoesNotExistException.class})
	public ResponseEntity<String> handleNotFound(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IllegalTransitionException.class)
	public ResponseEntity<String> handleConflicts(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
	}
	
}
