package com.organization.mvcproject.service;


//Why is this ArrayList called here?  Do we need to use ArrayList instead of List?
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.repository.MockDAO;

@Service
public class GameServiceImpl implements GameService {

	/**
	 * TODO 2.0 The class that interacts with persistent data is called a Data Access Object(DAO)
	 *  or a Repository class. The private static list is mocking our persistance of games.
	 *   
	 *  Move this list, and methods operating on this list to an appropriately named package and class.
	 *  
	 *  UPDATE: Sept-3-2021:  Moved functions to MockDAO.
	 *  All that remains is to make functions for them.
	 */
	
	@Autowired
	private MockDAO mockDao;
	
	
	//retrieveAllGames(): Gets all games on the system.
	@Override
	public List<Game> retrieveAllGames() {
		return MockDAO.getGames();
	}

	
	//saveGame: Saves a Game on the system.
	@Override
	public Game saveGame(Game game) {
		//game.setId(MockDAO.incrementGameId());
		MockDAO.saveGame(game);
		return game;
	}
	
	
	public boolean deleteGame(Long id) {
		
		return MockDAO.deleteGame(id);
	}


	/**
	 * findGamesByGenre
	 * 
	 * Return list of all games that match genre.  NULL if empty.
	 * 
	 * 
	 * @param genre
	 * @return
	 */
	public static List<Game> findGamesByGenre(String genre)
	{
		return MockDAO.findGamesByGenre(genre);
	}

}