package com.ssafy.fit.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.fit.model.dto.Board;

public interface BoardDao {
	// 게시글 목록
	List<Board> selectList(HashMap<String, String> params);
	
	// 게시글 조회
	Board selectOne(int id);
	
	// 게시글 등록
	void insertBoard(Board board);
	
	// 게시글 수정
	void updateBoard(Board board);
	
	// 게시글 삭제
	void deleteBoard(int id);
	
	// 댓글 개수 구하기
	public void updateBoardCommentCnt(@Param("id") int id, @Param("amount") int amount);
	
	// 작성자 이미지
	public String writerImg(int id);
}
