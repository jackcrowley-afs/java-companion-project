package com.organization.mvcproject.api.model;

public interface Review {
	
	public String getAuthor();

	public void setAuthor(String author);

	public Integer getRating();

	public void setRating(Integer rating);

	public String getBody();

	public void setReviewBody(String body);

}
