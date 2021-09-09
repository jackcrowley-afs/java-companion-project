package com.organization.mvcproject.model;

import org.springframework.stereotype.Component;

import com.organization.mvcproject.api.model.Review;

@Component
public class ReviewImpl implements Review {

	private String body;
	private String author;
	private Integer rating;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getBody() {
		return body;
	}

	public void setReviewBody(String body) {
		this.body = body;
	}
	
}
