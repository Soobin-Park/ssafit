package com.ssafy.fit.model.dto;

public class GymReview {
	private int gym_id; 
	private int review_id;
	private String writer;
	private String content;
	private double rating;
	private String createdAt;

	public GymReview() {

	}

	public GymReview(int gym_id, int review_id, String writer, String content, double rating, String createdAt) {
		super();
		this.gym_id = gym_id;
		this.review_id = review_id;
		this.writer = writer;
		this.content = content;
		this.rating = rating;
		this.createdAt = createdAt;
	}

	public int getGym_id() {
		return gym_id;
	}

	public void setGym_id(int gym_id) {
		this.gym_id = gym_id;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "GymReview [gym_id=" + gym_id + ", review_id=" + review_id + ", writer=" + writer + ", content="
				+ content + ", rating=" + rating + ", createdAt=" + createdAt + "]";
	}
	
}
	
	
	
	
	
