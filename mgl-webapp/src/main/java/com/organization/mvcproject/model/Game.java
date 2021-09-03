package com.organization.mvcproject.model;

import org.springframework.stereotype.Component;


@Component
public class Game {


	private Long id;
	private String name;
	private String genre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String game_name) {
		this.name = game_name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String game_genre) {
		this.genre = game_genre;
	}

}
