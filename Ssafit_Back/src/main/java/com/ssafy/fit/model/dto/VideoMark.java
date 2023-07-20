package com.ssafy.fit.model.dto;

public class VideoMark {
	private int id;
	private String user_id;
	private String video_id;
	
	public VideoMark(){
		
	}

	public VideoMark(int id, String user_id, String video_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.video_id = video_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	@Override
	public String toString() {
		return "VideoMark [id=" + id + ", user_id=" + user_id + ", video_id=" + video_id + "]";
	}
	
	
}
