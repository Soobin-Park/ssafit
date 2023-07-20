package com.ssafy.fit.model.dto;

public class VideoReview {
	private int review_id;
	private String video_id;
	private String writer;
	private String content;
	private String createdAt;
	private double rating;
	
	public VideoReview() {

	}

	public VideoReview(int review_id, String video_id, String writer, String content, String createdAt, double rating) {
		super();
		this.review_id = review_id;
		this.video_id = video_id;
		this.writer = writer;
		this.content = content;
		this.createdAt = createdAt;
		this.rating = rating;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "VideoReview [review_id=" + review_id + ", video_id=" + video_id + ", writer=" + writer + ", content="
				+ content + ", createdAt=" + createdAt + ", rating=" + rating + "]";
	}

}
	
	
	
	
	
