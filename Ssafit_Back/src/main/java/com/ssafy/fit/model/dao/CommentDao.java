package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.Comment;

public interface CommentDao {
	// 작성 글 아이디에 해당하는 댓글 리스트
	public List<Comment> selectComment(int board_id);
	
	// 댓글 조회
	public Comment selectOne(int comment_id);
	
	// 댓글 등록
	public int insertComment(Comment comment);
	
	// 댓글 수정
	public void updateComment(Comment comment);
	
	// 댓글 삭제
	public void deleteComment(int comment_id);
}
