package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;


public interface GameService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);
	
	boolean deleteGame(long id);
	
	List<Game> findGamesByGenre(String genre);

	Game fetchGameById(Long longId);

	Boolean updateGame(Game game, String genre, String name);

}
