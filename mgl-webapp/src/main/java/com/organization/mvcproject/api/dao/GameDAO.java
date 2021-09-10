package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.api.model.Game;

public interface GameDAO {

	public List<Game> getGames();

	
	public Long getGameId();

	
	public Long incrementGameId();

	
	public void addGame(Game game);

	
	public boolean deleteGame(Long gameId);
	
	public Game saveGame(Game game);
	
	public List<Game> findGamesByGenre(String genre);
	
}
