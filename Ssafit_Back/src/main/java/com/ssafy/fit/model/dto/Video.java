package com.ssafy.fit.model.dto;

public class Video {

	private String id;
	private String title;
	private int viewCnt;
	private String category; //운동 종류
	//다른 파일에 운동 부위가 다 category로 되어 있어서 싹 바꿔줘야 함
	private String part; //운동 부위
	private double rating_avg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public double getRating_avg() {
		return rating_avg;
	}

	public void setRating_avg(double rating_avg) {
		this.rating_avg = rating_avg;
	}

	public Video() {

	}

	public Video(String id, String title, int viewCnt, String category, String part, double rating_avg) {
		this.id = id;
		this.title = title;
		this.viewCnt = viewCnt;
		this.category = category;
		this.part = part;
		this.rating_avg = rating_avg;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", viewCnt=" + viewCnt + ", category=" + category + ", part="
				+ part + ", rating_avg=" + rating_avg + "]";
	}
	
}
