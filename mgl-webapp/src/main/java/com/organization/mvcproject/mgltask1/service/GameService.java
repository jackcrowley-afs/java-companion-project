package com.organization.mvcproject.mgltask1.service;

import java.util.List;

import com.organization.mvcproject.mgltask1.model.Game;


public interface GameService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

}
