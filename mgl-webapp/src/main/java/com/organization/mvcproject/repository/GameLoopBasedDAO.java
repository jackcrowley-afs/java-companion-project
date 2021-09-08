package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.model.Game;

/** MockDAO:
 * 
 *  2.0 Task:
 *  
 *  This class needs to 
 *  "lift the static List declaration of our data from the Service(GameServiceImpl or Game_Service_Impl) into the MockDAO."
 * 
 * 
 * 
 */

@Repository
public class GameLoopBasedDAO {

	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	
	public static List<Game> getGames()
	{
		return games;
	}
	
	public static Long getGameId()
	{
		return gameId;
	}
	
	public static Long incrementGameId()
	{
		return ++gameId;
	}
	
	public static void addGame(Game game)
	{	
		games.add(game);
	}
	
	
	/**
	 * saveGame
	 * 
	 * 2.0 Task:  Save a game, but update it if it already exists.
	 * 
	 * 
	 * @param game
	 * @return
	 */
	public static Game saveGame(Game game)
	{
		
		//if the game ID is already there, we need to check the existing values.
		if(game.getId() != null)
		{
			Game foundGame = findGameById(game.getId());
					
			//If this is true, then we have a legit game with the same ID in the list.
			if(foundGame != null)
			{
				for (int x = 0 ; x < games.size() ; x++)
				{
					if(game.getId().equals(games.get(x).getId()))
					{
						//We have confirmed this game exists.  We update and close.
						return games.set(x, game);
					}
					
				}
			}
			
		}
		
		game.setId(++gameId);
		
		//This cast is considered unnecessary, but we need to 2.1 refactoring.
		games.add((Game)game);
		
		return game;
		
	}


	/**
	 * findGameById
	 * 
	 * Find the first game in the ArrayList with the specified ID.
	 * 
	 * 
	 * 
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
	 * 
	 * Note: Game IDs are unique.  There should be no collisions within the list.
	 * 
	 * @param id
	 * @return
	 */
	public static boolean deleteGame(Long id) {
		
		for (int x = 0 ; x < games.size() ; x++)
		{
			if(id == games.get(x).getId())
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
	 * @param genre
	 * @return
	 */
	public static List<Game> findGamesByGenre(String genre) {
		
		
		List<Game> returnList = new ArrayList<Game>();
		
		for (Game game : games)
		{
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
