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
	
	
	@Override
	public List<Game> retrieveAllGames() {
		return mockDao.getGames();
	}

	
	@Override
	public Game saveGame(Game game) {
		//game.setId(MockDAO.incrementGameId());
		mockDao.saveGame(game);
		return game;
	}
	
	
	public boolean deleteGame(long id) {
		
		
		
		return mockDao.deleteGame(id);
	}


	/**
	 * findGamesByGenre
	 * 
	 * Return list of all games that match genre.  NULL if empty.
	 * 
	 * Suggested from the examples.
	 * 
	 * @param genre of a game to find.
	 * @return List of all games that match genre.
	 */
	@Override
	public List<Game> findGamesByGenre(String genre)
	{
		return mockDao.findGamesByGenre(genre);
	}


	@Override
	public Boolean updateGame(Game game, String genre, String name) {
		
		
		game.setGenre(genre);
		
		game.setName(name);
		
		mockDao.saveGame(game);
		
		return true;
	}


	@Override
	public Game fetchGameById(Long longId) {
		
		return mockDao.fetchGameById(longId);
	}

}