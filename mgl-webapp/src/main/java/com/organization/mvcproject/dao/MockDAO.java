package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

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
public class MockDAO {

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
	
}
