package com.ssafy.fit.model.dto;

public class Review {
	private int id; 
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private String createdAt;
	private String modifiedAt;
	private String videoId;
	
	public Review() {
		super();
	}
		
	public Review(int id, String title, String writer, String content, int viewCnt, String createdAt, String modifiedAt,
			String videoId) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCnt = viewCnt;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.videoId = videoId;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", viewCnt="
				+ viewCnt + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", videoId=" + videoId + "]";
	}
	
	
}
	
	
	
	
	
