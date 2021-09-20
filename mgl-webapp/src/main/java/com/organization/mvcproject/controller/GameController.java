package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImpl;


@RestController
public class GameController {

	
	@Autowired
	private GameService gameService;
	
	
	@GetMapping(value = "/game/")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	
	@PostMapping(value = "/game/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl game) {
		
		
		//TODO: (Optional) Return the saved game back from gameService.
		//Note: This may require changing the Game DAO work.
		gameService.saveGame(game);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	

	@DeleteMapping(value = "/game/{id}")
	public ResponseEntity<Boolean> deleteGame(@PathVariable String id)
	{
		//Long Helper method parses the ID string into a long.
		//We use longs for the ID because they are huge.
		
		
		//But the max number of something in javascript is quite smaller than a long in java.		
		//Treating this as a string also prevents any loss of information.
		
		Long longId = Long.valueOf(id);
		
		Boolean ans = gameService.deleteGame(longId);
		
		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);
	}
	
	//TODO: Make this format go root/a/b/c (for path variable system)
	//Look up @PathParam Annotation
	@PutMapping(value = "/game/{id},{name},{genre}")
	public ResponseEntity<Boolean> updateGame(@PathVariable String id, @PathVariable String name, @PathVariable String genre)
	{
		Long longId = Long.valueOf(id);
		
		
		//TODO: Use a Service to get an existing game rather than create a new one?
		//Make a Manager method called findGameByID to get an existing game, then send it back down.
		
		
		//TODO: Move the logic for setting the information into the Service.
		Game game = new GameImpl();
		
		game.setId(longId);
		
		game.setGenre(genre);
		
		game.setName(name);
		
		Boolean ans = gameService.updateGame(game);
		
		
		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);
	}
	
	@GetMapping(value = "/game/genre/{genre}")
	public ResponseEntity<List<Game>> getGamesByGenre(@PathVariable String genre) {
		
		
		return new ResponseEntity<List<Game>>(gameService.findGamesByGenre(genre), HttpStatus.OK);
	}
	
}