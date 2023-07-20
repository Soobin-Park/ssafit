package com.ssafy.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.fit.model.dao.BoardDao;
import com.ssafy.fit.model.dao.CommentDao;
import com.ssafy.fit.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private BoardDao boardDao;
	
	// 작성 글 아이디에 해당하는 댓글 리스트
	@Override
	public List<Comment> getCommentByBoardId(int board_id) {
		return commentDao.selectComment(board_id);
	}
	
	// 댓글 조회
	@Override
	public Comment getComment(int comment_id) {
		return commentDao.selectOne(comment_id);
	}
	
	// 댓글 등록
	@Transactional
	@Override
	public int insertComment(Comment comment) {
		boardDao.updateBoardCommentCnt(comment.getBoard_id(), 1);
		int result = commentDao.insertComment(comment);
		return result;
	}
	
	// 댓글 수정
	@Override
	public void updateComment(Comment comment) {
		commentDao.updateComment(comment);
	}
	
	// 댓글 삭제
	@Transactional
	@Override
	public void deleteComment(int comment_id) {
		Comment comment = commentDao.selectOne(comment_id);
		boardDao.updateBoardCommentCnt(comment.getBoard_id(), -1);
		commentDao.deleteComment(comment_id);
	}
	
}
