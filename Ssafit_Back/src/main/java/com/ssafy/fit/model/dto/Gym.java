package com.ssafy.fit.model.dto;

public class Gym {
	private int id;
	private String name;
	private String address;
	private String phoneNum;
	private String hours;
	private double rating_avg; //별점 평균
	private int reviewCnt; // 리뷰 개수
	
	public Gym() {
		
	}

	public Gym(int id, String name, String address, String phoneNum, String hours, double rating_avg, int reviewCnt) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.hours = hours;
		this.rating_avg = rating_avg;
		this.reviewCnt = reviewCnt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public double getRating_avg() {
		return rating_avg;
	}

	public void setRating_avg(double rating_avg) {
		this.rating_avg = rating_avg;
	}
	
	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	@Override
	public String toString() {
		return "Gym [id=" + id + ", name=" + name + ", address=" + address + ", phoneNum=" + phoneNum + ", hours="
				+ hours + ", rating_avg=" + rating_avg + ", reviewCnt=" + reviewCnt + "]";
	}

}
