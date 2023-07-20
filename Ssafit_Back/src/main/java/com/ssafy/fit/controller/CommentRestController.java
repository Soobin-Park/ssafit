package com.ssafy.fit.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fit.model.dto.Comment;
import com.ssafy.fit.model.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@Api(tags = "댓글 컨트롤러")
@RequestMapping("/api-comment")
public class CommentRestController {
	
	@Autowired
	private CommentService commentService;
	
	// 글 아이디에 맞는 댓글
	@GetMapping("/comment/{board_id}")
	public ResponseEntity<?> getAllComment(@PathVariable int board_id) {
		List<Comment> list = commentService.getCommentByBoardId(board_id);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
	}
	
	// 댓글 조회
	@GetMapping("/comment/one/{comment_id}")
	public ResponseEntity<?> getComment(@PathVariable int comment_id) {
		Comment comment = commentService.getComment(comment_id);
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}
	
	// 댓글 작성
	@PostMapping("/comment")
	public ResponseEntity<Comment> write(Comment comment) {
		commentService.insertComment(comment);
		return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
	}
	
	// 댓글 수정
	@PutMapping("/comment")
	public ResponseEntity<Void> update(@RequestBody Comment comment) {
		commentService.updateComment(comment);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 댓글 삭제
	@DeleteMapping("/comment/{comment_id}")
	public ResponseEntity<Void> delete(@PathVariable int comment_id) {
		commentService.deleteComment(comment_id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
