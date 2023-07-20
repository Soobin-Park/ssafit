package com.ssafy.fit.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.fit.model.dto.Board;

public interface BoardService {
	// 게시글 목록
	List<Board> getBoardList(HashMap<String, String> params);
	
	// 게시글 조회
	Board getBoard(int id);
	
	// 게시글 조회수 증가
	void updateViewCnt(int id);
	
	// 게시글 등록
	void writeBoard(Board board);
	
	// 게시글 수정
	void updateBoard(Board board);
	
	// 게시글 삭제
	void deleteBoard(int id);
	
	// 작성자 이미지
	public String getWriterImg(int id);
}
