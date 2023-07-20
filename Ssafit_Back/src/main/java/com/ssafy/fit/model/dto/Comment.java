package com.ssafy.fit.model.dto;

public class Comment {
	private int comment_id; 
	private int board_id;
	private String writer;
	private String content;
	private String createdAt;

	public Comment() {

	}

	public Comment(int comment_id, int board_id, String writer, String content, String createdAt) {
		this.comment_id = comment_id;
		this.board_id = board_id;
		this.writer = writer;
		this.content = content;
		this.createdAt = createdAt;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
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

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", board_id=" + board_id + ", writer=" + writer + ", content="
				+ content + ", createdAt=" + createdAt + "]";
	}

}
	
	
	
	
	
