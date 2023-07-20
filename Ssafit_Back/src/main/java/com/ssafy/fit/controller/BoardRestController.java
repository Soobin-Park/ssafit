package com.ssafy.fit.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fit.model.dto.Board;
import com.ssafy.fit.model.service.BoardService;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(tags ="커뮤니티 게시글 컨트롤러")
@RequestMapping("/api-board")
public class BoardRestController {
	private static final String SUCCESS = "success";
	
	@Autowired
	private BoardService boardService;
	
	// 게시글 목록
	@GetMapping("/board")
	public ResponseEntity<List<Board>> getBoard(@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {
		HashMap<String, String> params = new HashMap<String, String>();
		
		params.put("mode", mode);
		params.put("keyword", keyword);
		
		return new ResponseEntity<List<Board>>(boardService.getBoardList(params), HttpStatus.OK);
	}
	
	// 게시글 등록
	@PostMapping("/board")
	public ResponseEntity<String> write(Board board) {
		boardService.writeBoard(board);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}
	
	// 게시글 상세
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable int id) {
		Board board = boardService.getBoard(id);
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	// 게시글 수정
	@PutMapping("/board")
	public ResponseEntity<String> update(Board board) {
		boardService.updateBoard(board);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	// 게시글 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		boardService.deleteBoard(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 작성자 이미지
	@GetMapping("/board/img/{id}")
	public ResponseEntity<String> writerImg(@PathVariable int id) {
		String img = boardService.getWriterImg(id);
		return new ResponseEntity<String>(img, HttpStatus.OK);
	}
}
