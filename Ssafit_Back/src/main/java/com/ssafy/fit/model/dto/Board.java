package com.ssafy.fit.model.dto;

public class Board {
	private int id;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private String createdAt;
	private int commentCnt; // 댓글 수
	
	public Board() {
		
	}
	
	public Board(int id, String title, String content, String writer, int viewCnt, String createdAt, int commentCnt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.viewCnt = viewCnt;
		this.createdAt = createdAt;
		this.commentCnt = commentCnt;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
	
	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer + ", viewCnt="
				+ viewCnt + ", createdAt=" + createdAt + ", commentCnt=" + commentCnt + "]";
	}

}
