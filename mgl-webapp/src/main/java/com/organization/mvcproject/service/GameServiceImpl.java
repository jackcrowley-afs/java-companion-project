package com.organization.mvcproject.service;


//Why is this ArrayList called here?  Do we need to use ArrayList instead of List?
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.repository.GameLoopBasedDAO;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameLoopBasedDAO mockDao;
	
	
	//retrieveAllGames(): Gets all games on the system.
	@Override
	public List<Game> retrieveAllGames() {
		return GameLoopBasedDAO.getGames();
	}

	
	//saveGame: Saves a Game on the system.
	@Override
	public Game saveGame(Game game) {
		//game.setId(MockDAO.incrementGameId());
		GameLoopBasedDAO.saveGame(game);
		return game;
	}
	
	
	public boolean deleteGame(Long id) {
		
		return GameLoopBasedDAO.deleteGame(id);
	}


	/**
	 * findGamesByGenre
	 * 
	 * Return list of all games that match genre.  NULL if empty.
	 * 
	 * Suggested from the examples.
	 * 
	 * @param genre
	 * @return
	 */
	public static List<Game> findGamesByGenre(String genre)
	{
		return GameLoopBasedDAO.findGamesByGenre(genre);
	}

}