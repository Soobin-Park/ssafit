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

import com.ssafy.fit.model.dto.GymReview;
import com.ssafy.fit.model.service.GymReviewService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@Api(tags = "헬스장 리뷰 컨트롤러")
@RequestMapping("/api-gymReview")
public class GymReviewRestController {
	
	@Autowired
	private GymReviewService grService;
	
	// 헬스장 아이디에 해당하는 리뷰 목록
	@GetMapping("/review")
	public ResponseEntity<?> getGymReviews(int gym_id) {
		List<GymReview> list = grService.getReviewByGymId(gym_id);
		
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<GymReview>>(list, HttpStatus.OK);
	}
	
	// 리뷰 등록
	@PostMapping("/review")
	public ResponseEntity<GymReview> write(GymReview gymReview) {
		grService.insertGymReview(gymReview);
		return new ResponseEntity<GymReview>(gymReview, HttpStatus.CREATED);
	}
	
	// 리뷰 수정
	@PutMapping("/review")
	public ResponseEntity<Void> update(@RequestBody GymReview gymReview) {
		grService.updateGymReview(gymReview);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 리뷰 삭제
	@DeleteMapping("/review/{review_id}")
	public ResponseEntity<Void> delete(@PathVariable int review_id) {
		grService.deleteGymReview(review_id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
