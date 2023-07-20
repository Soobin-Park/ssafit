package com.ssafy.fit.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fit.model.dao.BoardDao;
import com.ssafy.fit.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> getBoardList(HashMap<String, String> params) {
		return boardDao.selectList(params);
	}

	@Override
	public Board getBoard(int id) {
		this.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public void updateViewCnt(int id) {
		Board board = boardDao.selectOne(id);
		board.setViewCnt(board.getViewCnt()+1);
		boardDao.updateBoard(board);
	}

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		Board originBoard = boardDao.selectOne(board.getId());
		originBoard.setTitle(board.getTitle());
		originBoard.setContent(board.getContent());
		boardDao.updateBoard(originBoard);
	}

	@Override
	public void deleteBoard(int id) {
		boardDao.deleteBoard(id);
	}
	
	// 작성자 이미지
	@Override
	public String getWriterImg(int id) {
		return boardDao.writerImg(id);
	}
}
