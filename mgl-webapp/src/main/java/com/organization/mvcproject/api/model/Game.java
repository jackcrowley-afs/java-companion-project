package com.organization.mvcproject.api.model;


public interface Game {


	public Long getId();
	
	public void setId(Long id);
	
	public String getName();
	
	public void setName(String name);

	public String getGenre();
	
	public void setGenre(String genre);
	
	public String toString();
	
}
