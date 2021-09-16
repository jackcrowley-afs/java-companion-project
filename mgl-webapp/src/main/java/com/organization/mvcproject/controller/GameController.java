package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.model.Review;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImpl;


@RestController
public class GameController {

	
	@Autowired
	private GameService gameManager;
	
	
	@GetMapping(value = "/game/")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameManager.retrieveAllGames(), HttpStatus.OK);
	}

	
	@PostMapping(value = "/game/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl game) {
		gameManager.saveGame(game);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	

	@DeleteMapping(value = "/game/{id}")
	public ResponseEntity<Boolean> deleteGame(@PathVariable String id)
	{
		Long longId = Long.valueOf(id);
		
		Boolean ans = gameManager.deleteGame(longId);
		
		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);
	}
	
	@PutMapping(value = "/game/{id},{name},{genre}")
	public ResponseEntity<Boolean> updateGame(@PathVariable String id, @PathVariable String name, @PathVariable String genre)
	{
		Long longId = Long.valueOf(id);
		
		Game game = new GameImpl();
		
		game.setId(longId);
		
		game.setGenre(genre);
		
		game.setName(name);
		
		Boolean ans = gameManager.updateGame(game);
		
		
		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);
	}
	
	@GetMapping(value = "/game/genre/{genre}")
	public ResponseEntity<List<Game>> getGamesByGenre(@PathVariable String genre) {
		return new ResponseEntity<List<Game>>(gameManager.findGamesByGenre(genre), HttpStatus.OK);
	}
	
}