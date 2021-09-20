package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

/** <p>This class is an implementation of the GameDAO interface.</p>
 * 
 *  Required Tasks:
 *  
 *  <ul>
 *  	<li>Add new games</li>
 *   	<li>Delete a game given an id</li>
 *   	<li>Update a game given an id</li>
 *   	<li>Return a list of all games based on the Genre</li>
 *  
 *  </ul>
 */

@Repository
public class GameLoopBasedDAO implements GameDAO {

	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	
	public List<Game> getGames()
	{
		return games;
	}
	
	public Long getGameId()
	{
		return gameId;
	}
	
	public Long incrementGameId()
	{
		return ++gameId;
	}
	
	public void addGame(Game game)
	{	
		games.add(game);
	}
	
	
	/**
	 * saveGame
	 * 
	 * 2.0 Task:  Save a game, but update it if it already exists.
	 * 
	 * 
	 * @param game which has an id number that we check for.
	 * @return game, if we find no id collision.  Otherwise, the game with the id collision.
	 */
	public Game saveGame(Game game)
	{
		
		
		if(game.getId() != null)
		{
			Game foundGame = findGameById(game.getId());
					
			
			if(foundGame != null)
			{
				for (int x = 0 ; x < games.size() ; x++)
				{
					if(game.getId().equals(games.get(x).getId()))
					{
						
						return games.set(x, game);
					}
					
				}
			}
			
		}
		
		game.setId(++gameId);
		
		games.add((Game)game);
		
		return game;
		
	}


	/**
	 * findGameById
	 * 
	 * Find the first game in the ArrayList with the specified ID.
	 * 
	 * @param id
	 * @return
	 */
	public static Game findGameById(Long id) {
		
		for (Game game : games)
		{
			if(game.getId().equals(id))
			{
				return game;
			}
			
		}
		
		
		return null;
	}
	
	/**
	 * deleteGame
	 * 
	 * Deletes the game that matches the ID of the parameter.
	 * Note: Game IDs are unique.  There should be no collisions within the list.
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteGame(Long id) {
		
		for (int x = 0 ; x < games.size() ; x++)
		{
			if(games.get(x).getId().equals(id))
			{
				games.remove(games.get(x));
				return true;
			}
			
		}
		
		return false;
	}


	/**
	 * findGamesByGenre
	 * 
	 * Return a list of all games found that match the genre parameter.
	 * Return null if nothing is found.
	 *
	 * @param genre of the games to find.
	 * @return List of all the Games that match the genre.
	 */
	public List<Game> findGamesByGenre(String genre) {
		
		
		List<Game> returnList = new ArrayList<Game>();
		
		for (Game game : games)
		{
			//This is NOT null safe.
			//genre should NOT be null
			//TODO: Either do a null check or ensure we aren't getting a null here.
			if(game.getGenre().equals(genre))
			{
				returnList.add(game);
			}
		}
		
		
		//Specification from the Example.  We should have it return 
		//NULL if it found nothing, just for safety.
		return (returnList.isEmpty() ? null : returnList);
	}
	
	
}
