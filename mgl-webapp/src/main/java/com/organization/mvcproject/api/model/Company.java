
package com.organization.mvcproject.api.model;

import java.util.List;

import com.organization.mvcproject.model.Game;


public interface Company {


	public Long getId();
	
	public String getName();
	
	public void setName(String name);
	
	
	public List<Game> getGamesMade();
	
	public void setGamesMade(List<Game> gamesMade);
	
}